package akkocdesign.hrms.business.concretes;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.EmployerService;
import akkocdesign.hrms.business.constants.Messages;
import akkocdesign.hrms.core.utilities.results.DataResult;
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
		this.employerDao.save(employer);
        return new SuccessResult(Messages.employerAdded);
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}
	
	
}
