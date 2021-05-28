package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	//HRMS v1
	JobTitle findByJobTitle(String title);
	
	//HRMS v3
	//JobTitle findByTitleName(String titleName);
}
