package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
