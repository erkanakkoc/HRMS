package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateCoverLetterService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import akkocdesign.hrms.entities.concretes.CandidateCoverLetter;

@Service("CandidateCoverLetterManager")
public class CandidateCoverLetterManager implements CandidateCoverLetterService{

	private CandidateCoverLetterDao candidateCoverLetterDao;
	
	@Autowired
	public CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao) {
		super();
		this.candidateCoverLetterDao = candidateCoverLetterDao;
	}

	@Override
	public Result add(CandidateCoverLetter candidateCoverLetter) {
		this.candidateCoverLetterDao.save(candidateCoverLetter);
		return new SuccessResult("Cover letter has been added.");
	}

	@Override
	public Result update(CandidateCoverLetter candidateCoverLetter) {
		this.candidateCoverLetterDao.save(candidateCoverLetter);
		return new SuccessResult("Cover letter has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateCoverLetterDao.deleteById(id);
        return new SuccessResult("Cover letter has been deleted.");
	}

	@Override
	public DataResult<CandidateCoverLetter> getById(int id) {
		return new SuccessDataResult<CandidateCoverLetter>(this.candidateCoverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateCoverLetter>> getAll() {
		return new SuccessDataResult<List<CandidateCoverLetter>>(this.candidateCoverLetterDao.findAll());
	}
	
}
