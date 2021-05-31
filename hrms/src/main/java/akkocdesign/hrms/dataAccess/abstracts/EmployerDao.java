package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	 Employer getById(int id);
	
	//HRMS v3
	// Employer findByEmail(String email);
}
