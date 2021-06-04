package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation schoolForCV);
	Result update(CandidateEducation schoolForCV);
	Result delete(int id);
	DataResult<CandidateEducation> getById(int id);	
	DataResult<List<CandidateEducation>> getAll();
	DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByEndAtDesc(int id);
	DataResult<List<CandidateEducation>> getAllByCandidateId(int id);
}
