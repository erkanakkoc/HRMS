package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateTalentService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateTalentDao;
import akkocdesign.hrms.entities.concretes.CandidateTalent;

@Service("CandidateTalentManager")
public class CandidateTalentManager implements CandidateTalentService{

	private CandidateTalentDao candidateTalentDao;
	
	@Autowired
	public CandidateTalentManager(CandidateTalentDao candidateTalentDao) {
		super();
		this.candidateTalentDao = candidateTalentDao;
	}

	@Override
	public Result add(CandidateTalent candidateTalent) {
		this.candidateTalentDao.save(candidateTalent);
		return new SuccessResult("Programming skill has been added.");
	}

	@Override
	public Result update(CandidateTalent candidateTalent) {
		this.candidateTalentDao.save(candidateTalent);
		return new SuccessResult("Programming skill has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateTalentDao.deleteById(id);
		return new SuccessResult("Programming skill has been deleted.");
	}

	@Override
	public DataResult<CandidateTalent> getById(int id) {
		return new SuccessDataResult<CandidateTalent>(this.candidateTalentDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateTalent>> getAll() {
		return new SuccessDataResult<List<CandidateTalent>>(this.candidateTalentDao.findAll());
	}

	@Override
	public DataResult<List<CandidateTalent>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateTalent>>(this.candidateTalentDao.getAllByCandidate_id(id));
	}

}
