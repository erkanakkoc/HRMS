package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId);
}
