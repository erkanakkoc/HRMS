package akkocdesign.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.business.abstracts.CandidateImageService;
import akkocdesign.hrms.core.utilities.helpers.imageUpload.CloudinaryImageUploadService;
import akkocdesign.hrms.core.utilities.helpers.imageUpload.ImageUploadService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateImageDao;
import akkocdesign.hrms.entities.concretes.CandidateImage;

@Service("CandidateImageManager")
public class CandidateImageManager implements CandidateImageService{

	private CandidateImageDao candidateImageDao;
	private CloudinaryImageUploadService cloudinaryImageUploadService;
	//private ImageUploadService imageUploadService;
	
//	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageUploadService imageUploadService) {
//		super();
//		this.candidateImageDao = candidateImageDao;
//		this.imageUploadService = imageUploadService;
//	}


	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao,
			CloudinaryImageUploadService cloudinaryImageUploadService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.cloudinaryImageUploadService = cloudinaryImageUploadService;
	}


	@Override
	public Result add(CandidateImage candidateImage, MultipartFile imageFile) {
	//	Map<String,String> uploadImage = this.cloudinaryImageUploadService.uploadImageFile(imageFile).getData();
	//	candidateImage.setUrl(uploadImage.get("url"));
	//	this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Image has been added.");
	}

	@Override
	public Result update(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Image has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateImageDao.deleteById(id);
		return new SuccessResult("Image has been deleted.");
	}

	@Override
	public DataResult<CandidateImage> getById(int id) {
		return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll());
	}

	@Override
	public DataResult<CandidateImage> getByCandidateId(int id) {
		return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getByCandidate_id(id));
	}



}
