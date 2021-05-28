package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getByNationalId(String nationalId);
	Result add(Candidate candidate);
	
	
	
	
	DataResult<Candidate> getByEmail(String email);
	
}
