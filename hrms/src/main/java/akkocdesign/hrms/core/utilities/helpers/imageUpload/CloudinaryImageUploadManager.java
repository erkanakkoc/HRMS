package akkocdesign.hrms.core.utilities.helpers.imageUpload;

import java.io.IOException; 
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;

@Service("CloudinaryImageUploadManager")
public class CloudinaryImageUploadManager implements CloudinaryImageUploadService{

	private Cloudinary cloudinary;
	
	public CloudinaryImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dayx2sam5",
				"api_key", "699443261618643",
				"api_secret", "LaC_8aO4_p-vseLXfpOJGuC-sjI"));
	}
	
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}
	

}
