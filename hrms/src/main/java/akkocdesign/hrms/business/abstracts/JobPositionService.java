package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);
}
