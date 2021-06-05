package akkocdesign.hrms.business.abstracts;
 
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {
	Result add(CandidateImage candidateImage, MultipartFile imageFile);
	Result update(CandidateImage candidateImage);
	Result delete(int id);
	DataResult<CandidateImage> getById(int id);	
	DataResult<List<CandidateImage>> getAll();
	DataResult<CandidateImage> getByCandidateId(int id);
	
}
