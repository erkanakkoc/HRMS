package akkocdesign.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateService;
import akkocdesign.hrms.core.utilities.adapters.mernis.UserCheckService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateDao;
import akkocdesign.hrms.entities.concretes.Candidate;

@Service("CandidateManager")
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> getByNationalId(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalId));
	}

	@Override
	public Result add(Candidate candidate) {
		if(!validationForCandidate(candidate)) {
			return new ErrorResult("Missing information...");
		}
		
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Invalid person...");
		}
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email already exist...");
		}
		if(!checkIfNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Nationality already exist...");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added !");
	}
	
	
	//BUSINESS RULES
	
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkIfNationalityId(String nationalityId) {
		if(this.candidateDao.findByNationalityId(nationalityId)!=null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfRealPerson(Candidate candidate) {
		   if(!this.userCheckService.checkIfRealPerson(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toLowerCase(new Locale("tr")),
				   candidate.getDateOfBirth())) {
			   
			   return false;
		   }
		   return true;
			
		}
		

	private boolean validationForCandidate(Candidate candidate) {
		
		if(candidate.getFirstName() == null && candidate.getLastName() == null && candidate.getNationalityId() == null
				&& candidate.getDateOfBirth() == null && candidate.getEmail() == null) {
			return false;
					
		}
		return true;
	}
}
