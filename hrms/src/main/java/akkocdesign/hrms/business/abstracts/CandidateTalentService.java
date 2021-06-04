package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateTalent;

public interface CandidateTalentService {
	Result add(CandidateTalent candidateTalent);
	Result update(CandidateTalent candidateTalent);
	Result delete(int id);
	DataResult<CandidateTalent> getById(int id);	
	DataResult<List<CandidateTalent>> getAll();
	DataResult<List<CandidateTalent>> getAllByCandidateId(int id);
}
