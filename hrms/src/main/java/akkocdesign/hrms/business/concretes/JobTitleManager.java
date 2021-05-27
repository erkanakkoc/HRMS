package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.JobTitleService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.dataAccess.abstracts.JobTitleDao;
import akkocdesign.hrms.entities.concretes.JobTitle;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;

@Service("JobTitleManager")
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Listed All Datas");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if (!this.isTitleExist(jobTitle.getTitleName())) {
			return new ErrorResult("Job Title is Already Exist!");
		}

		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job Title Added");
	}

	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job Title Updated");
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult("Job Title Deleted");
	}

	private boolean isTitleExist(String titleName) {
		if (this.jobTitleDao.findByTitleName(titleName) != null) {
			return false;
		}
		return true;
	}

}
