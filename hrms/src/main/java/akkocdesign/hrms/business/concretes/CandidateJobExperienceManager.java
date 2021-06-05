package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateJobExperienceService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import akkocdesign.hrms.entities.concretes.CandidateJobExperience;

@Service("CandidateJobExperienceManager")
public class CandidateJobExperienceManager  implements CandidateJobExperienceService{

	private CandidateJobExperienceDao candidateJobExperienceDao;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
	}

	@Override
	public Result add(CandidateJobExperience candidateJobExperience) {
		this.candidateJobExperienceDao.save(candidateJobExperience);
		return new SuccessResult("Experience has been added.");
	}

	@Override
	public Result update(CandidateJobExperience candidateJobExperience) {
		this.candidateJobExperienceDao.save(candidateJobExperience);
		return new SuccessResult("Experience has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateJobExperienceDao.deleteById(id);
		return new SuccessResult("Experience has been deleted.");
	}

	@Override
	public DataResult<CandidateJobExperience> getById(int id) {
		return new SuccessDataResult<CandidateJobExperience>(this.candidateJobExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAllByCandidateIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.getAllByCandidate_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.getAllByCandidate_id(id));
	}

}
