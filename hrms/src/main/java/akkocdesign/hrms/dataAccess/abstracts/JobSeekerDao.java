package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findJobSeekerByNationalId(String nationalId);
	JobSeeker getById(int id);
}
