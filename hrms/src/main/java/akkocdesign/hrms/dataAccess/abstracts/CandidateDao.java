package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	//HRMS v1
	Candidate findJobseekerByNationalId(String nationalId);
	
	//HRMS v3
	//Candidate findByNationalityId(String nationalityId);
	
	//Candidate findByEmail(String email);
}
