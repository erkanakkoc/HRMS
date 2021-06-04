package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkService {
	Result add(CandidateLink candidateLink);
	Result update(CandidateLink candidateLink);
	Result delete(int id);
	DataResult<CandidateLink> getById(int id);	
	DataResult<List<CandidateLink>> getAll();
	DataResult<List<CandidateLink>> getAllByCandidateId(int id);
}
