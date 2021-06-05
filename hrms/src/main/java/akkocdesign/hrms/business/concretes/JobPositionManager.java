package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.JobPositionService;
import akkocdesign.hrms.business.constants.Messages;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.ErrorResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.JobPositionDao;
import akkocdesign.hrms.entities.concretes.JobPosition;

@Service("JobPositionManager")
public class JobPositionManager implements JobPositionService{
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(getJobByTitle(jobPosition.getJobTitle()).getData() != null){
			return new ErrorResult( jobPosition.getJobTitle() + Messages.jobPositionWithTitleAlreadyExits);
		}
		this.jobPositionDao.save(jobPosition);
	    return new SuccessResult(Messages.jobPositionAdded);
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getJobByTitle(String title) {
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(title));
	}
}
