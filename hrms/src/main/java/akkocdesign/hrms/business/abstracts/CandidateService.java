package akkocdesign.hrms.business.abstracts;

import java.util.List; 

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.dtos.CandidateCVDto;

public interface CandidateService {
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Result delete(int id);
	DataResult<Candidate> getById(int id);
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByNationalId(String nationalId);
	DataResult<CandidateCVDto> getCandidateCVById(int id);
}
