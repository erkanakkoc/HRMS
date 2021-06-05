package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateLanguageService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateLanguageDao;
import akkocdesign.hrms.entities.concretes.CandidateLanguage;

@Service("CandidateLanguageManager")
public class CandidateLanguageManager implements CandidateLanguageService{

	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Foreign language has been added.");
	}

	@Override
	public Result update(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Foreign language has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateLanguageDao.deleteById(id);;
		return new SuccessResult("Foreign language has been deleted.");
	}

	@Override
	public DataResult<CandidateLanguage> getById(int id) {
		return new SuccessDataResult<CandidateLanguage>(this.candidateLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getAllByCandidate_id(id));
	}

}
