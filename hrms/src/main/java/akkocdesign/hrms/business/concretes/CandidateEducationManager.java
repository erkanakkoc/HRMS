package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateEducationService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateEducationDao;
import akkocdesign.hrms.entities.concretes.CandidateEducation;

@Service("CandidateEducationManager")
public class CandidateEducationManager implements CandidateEducationService{

	private CandidateEducationDao candidateEducationDao;
	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("School has been added.");
	}

	@Override
	public Result update(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("School has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateEducationDao.deleteById(id);
		return new SuccessResult("School has been deleted.");
	}

	@Override
	public DataResult<CandidateEducation> getById(int id) {
		return new SuccessDataResult<CandidateEducation>(this.candidateEducationDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll());
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCandidate_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getAllByCandidate_id(id));
	}

}
