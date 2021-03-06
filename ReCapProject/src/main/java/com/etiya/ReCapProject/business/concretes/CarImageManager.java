package com.etiya.ReCapProject.business.concretes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.business.BusinessRules;
import com.etiya.ReCapProject.core.constants.FilePathConfiguration;
import com.etiya.ReCapProject.core.utilities.helpers.FileHelper;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CarDao;
import com.etiya.ReCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.dtos.CarImageDetailDto;
import com.etiya.ReCapProject.entities.requests.carImage.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.carImage.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.carImage.UpdateCarImageRequest;

@Service
public class CarImageManager implements CarImageService {

	private CarImageDao carImageDao;
	private ModelMapper modelMapper;
	private CarDao carDao;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapper modelMapper,CarDao carDao) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapper = modelMapper;
		this.carDao=carDao;
	}

	@Override
	public DataResult<List<CarImageDetailDto>> getAll() {
		List<CarImage> carImages = this.carImageDao.findAll();

		List<CarImageDetailDto> carImageDetailDtos = carImages.stream().map(carImage -> modelMapper.map(carImage, CarImageDetailDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CarImageDetailDto>>(carImageDetailDtos,Messages.CarsImagesListed);
	}

	@Override
	public DataResult<CarImageDetailDto> getById(int carImageId) {
		CarImage carImage = this.carImageDao.getById(carImageId);
		
		CarImageDetailDto carImageDetailDto = modelMapper.map(carImage, CarImageDetailDto.class);

		return new SuccessDataResult<CarImageDetailDto>(carImageDetailDto,Messages.GetCarImage);
	}

	@Override
	public DataResult<List<CarImageDetailDto>> getByCarId(int carId) {
		List<CarImage> carImages = this.ifCarImageIsNullAddLogo(carId);

		List<CarImageDetailDto> carImageDetailDtos = carImages.stream().map(carImage -> modelMapper.map(carImage, CarImageDetailDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CarImageDetailDto>>(carImageDetailDtos,Messages.GetCarImages);
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {

		var result = BusinessRules.run(checkIfCarImageLimitExceeded(createCarImageRequest.getCarId(), 5),
				checkImageType(createCarImageRequest.getFile()), checkCarImageIsNull(createCarImageRequest.getFile()));

		if (result != null) {
			return result;
		}

		LocalDate date = LocalDate.now();

		File imagePath = new FileHelper().createFile(createCarImageRequest.getFile());

		CarImage carImage = modelMapper.map(createCarImageRequest, CarImage.class);
		carImage.setDate(date);
		carImage.setImagePath(imagePath.toString());

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CarImageAdded);
	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		CarImage carImage = this.carImageDao.getById(deleteCarImageRequest.getCarImageId());

		this.carImageDao.delete(carImage);
		return new SuccessResult(Messages.CarImageDeleted);
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException {

		var result = BusinessRules.run(checkIfCarImageLimitExceeded(updateCarImageRequest.getCarId(), 5),
				checkImageType(updateCarImageRequest.getFile()), checkCarImageIsNull(updateCarImageRequest.getFile()));

		if (result != null) {
			return result;
		}

		LocalDate date = LocalDate.now();

		File imagePath = new FileHelper().createFile(updateCarImageRequest.getFile());

		CarImage carImage = this.carImageDao.getById(updateCarImageRequest.getCarImageId());
		carImage.setImagePath(imagePath.toString());
		carImage.setDate(date);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CarImageUpdated);
	}

	
	private Result checkIfCarImageLimitExceeded(int carId, int limit) {
		if (this.carImageDao.getByCar_CarId(carId).size() >= limit) {
			return new ErrorResult(Messages.Limit);
		}
		return new SuccessResult();
	}

	private Result checkCarImageIsNull(MultipartFile file) {
		if (file == null || file.isEmpty() || file.getSize() == 0)
			return new ErrorResult();

		return new SuccessResult();

	}

	private Result checkImageType(MultipartFile file) {

		if (checkCarImageIsNull(file).isSuccess()) {

			if (!file.getContentType().substring(file.getContentType().indexOf("/") + 1).equals("png")
					&& !file.getContentType().substring(file.getContentType().indexOf("/") + 1).equals("jpg")
					&& !file.getContentType().substring(file.getContentType().indexOf("/") + 1).equals("jpeg")) {
				System.out.println(file.getContentType());
				return new ErrorResult(Messages.FormatError);
			}
		}

		return new SuccessResult();
	}

	private List<CarImage> ifCarImageIsNullAddLogo(int carId) {
		if (this.carImageDao.getByCar_CarId(carId).isEmpty()) {

			Car car = this.carDao.getById(carId);
			car.setCarName(car.getCarName());

			List<CarImage> carImages = new ArrayList<CarImage>();
			
			CarImage carImage = new CarImage();
			carImage.setCar(car);
			carImage.setImagePath(FilePathConfiguration.CarImageDefaultPath);
			
			carImages.add(carImage);
			return carImages;

		}
		return new ArrayList<CarImage>(this.carImageDao.getByCar_CarId(carId));
	}

}