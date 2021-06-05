package akkocdesign.hrms.core.utilities.helpers.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
	DataResult<Map> delete(String id) throws IOException;
}
