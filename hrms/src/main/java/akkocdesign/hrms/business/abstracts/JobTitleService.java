package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	
	//HRMS v1
	DataResult<JobTitle> getJobByTitle(String title);
	
	
	Result add(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
}
