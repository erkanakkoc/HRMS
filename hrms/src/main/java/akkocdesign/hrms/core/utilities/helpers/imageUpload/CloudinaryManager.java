package akkocdesign.hrms.core.utilities.helpers.imageUpload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service("CloudinaryManager")
public class CloudinaryManager implements ImageUploadService{

Cloudinary cloudinary;
	
	public CloudinaryManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "drtniio0r",
				"api_key", "291971955751141",
				"api_secret", "29cADVk0cg6IPuEcFbzC_6jsWbU")); // silincek
	}
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException{
		// TODO Auto-generated method stub
		Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader  = null;
        try {
        	uploader = cloudinary.uploader().upload(file, options);
        }
        catch(Exception e) {
        	return new ErrorDataResult<>(e.getMessage()); // hatanın mesajı yakala
        }
        
		return new SuccessDataResult<>(uploader);
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException{
		// TODO Auto-generated method stub
		return null;
	}
	
	 private File convertToFile(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream stream = new FileOutputStream(file);
	        stream.write(multipartFile.getBytes());
	        stream.close();

	        return file;
	    }


}
