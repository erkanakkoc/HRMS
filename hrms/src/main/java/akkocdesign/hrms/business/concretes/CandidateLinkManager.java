package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateLinkService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateLinkDao;
import akkocdesign.hrms.entities.concretes.CandidateLink;

@Service("CandidateLinkManager")
public class CandidateLinkManager implements CandidateLinkService{

	private CandidateLinkDao candidateLinkDao;
	
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
		super();
		this.candidateLinkDao = candidateLinkDao;
	}

	@Override
	public Result add(CandidateLink candidateLink) {
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult("Link has been added.");
	}

	@Override
	public Result update(CandidateLink candidateLink) {
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult("Link has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateLinkDao.deleteById(id);
		return new SuccessResult("Link has been deleted.");
	}

	@Override
	public DataResult<CandidateLink> getById(int id) {
		return new SuccessDataResult<CandidateLink>(this.candidateLinkDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateLink>> getAll() {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.getAllByCandidate_id(id));
	}

}
