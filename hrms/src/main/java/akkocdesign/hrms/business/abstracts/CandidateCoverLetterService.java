package akkocdesign.hrms.business.abstracts;

import java.util.List; 

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateCoverLetter;

public interface CandidateCoverLetterService {
	Result add(CandidateCoverLetter candidateCoverLetter);
	Result update(CandidateCoverLetter candidateCoverLetter);
	Result delete(int id);
	DataResult<CandidateCoverLetter> getById(int id);	
	DataResult<List<CandidateCoverLetter>> getAll();
}
