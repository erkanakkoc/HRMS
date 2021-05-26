package akkocdesign.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.JobTitleService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.dataAccess.abstracts.JobTitleDao;
import akkocdesign.hrms.entities.concretes.JobTitle;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;

@Service
public class JobTitleManager implements JobTitleService{
	
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}



	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"Listed All Datas");
	}


	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job added");
	}


	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job added");
	}


	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult("Job added");
	}

}
