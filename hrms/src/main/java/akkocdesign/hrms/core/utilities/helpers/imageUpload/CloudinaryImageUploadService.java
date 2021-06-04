package akkocdesign.hrms.core.utilities.helpers.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageUploadService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
	}
