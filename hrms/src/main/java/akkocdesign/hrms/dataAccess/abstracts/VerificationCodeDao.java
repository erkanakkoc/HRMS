package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{
	
	//HRMSv3
	// VerificationCode findByUserIdAndVerificationCode(int userId, String verificationCode);


	//HRMSv1
	VerificationCode getById(int id);
}
