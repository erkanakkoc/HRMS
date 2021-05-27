package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.EmployerService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.EmployerDao;
import akkocdesign.hrms.entities.concretes.Employer;

@Service("EmployerManager")
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		if (!this.checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Email address is already exist!");
		}
		if (!this.validationForEmployer(employer)) {
			return new ErrorResult("Missing Information");			
		}
		if (!this.checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebSite())) {
			return new ErrorResult("Invalid Email Address");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
	
	private boolean checkIfEmailExists(String email) {
		if (this.employerDao.findByEmail(email) != null) {
			return false;			
		}
		return true;
	}
	
	private boolean validationForEmployer(Employer employer) {
		if (employer.getCompanyName() == null && employer.getWebSite() == null && employer.getEmail() == null && employer.getPhoneNumber() == null && employer.getPassword() == null) {
			return false;	
		}
		return true;
	}
	
	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@",2);
		String domain = website.substring(4, website.length());
		if (emailArr[1].equals(domain)) {
			return true;			
		}
		return false;
	}
	
	
}