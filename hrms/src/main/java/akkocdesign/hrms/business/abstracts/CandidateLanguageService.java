package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidateLanguage);
	Result update(CandidateLanguage candidateLanguage);
	Result delete(int id);
	DataResult<CandidateLanguage> getById(int id);	
	DataResult<List<CandidateLanguage>> getAll();
	DataResult<List<CandidateLanguage>> getAllByCandidateId(int id);
}
