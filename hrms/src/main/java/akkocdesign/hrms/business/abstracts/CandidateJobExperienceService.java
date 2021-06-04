package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceService {
	Result add(CandidateJobExperience candidateJobExperience);
	Result update(CandidateJobExperience candidateJobExperience);
	Result delete(int id);
	DataResult<CandidateJobExperience> getById(int id);	
	DataResult<List<CandidateJobExperience>> getAll();
	DataResult<List<CandidateJobExperience>> getAllByCandidateIdOrderByEndAtDesc(int id);
	DataResult<List<CandidateJobExperience>> getAllByCandidateId(int id);
}
