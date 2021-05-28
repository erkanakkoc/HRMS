package akkocdesign.hrms.core.utilities.verification;

public interface VerificationService {
	
	//HRMS v3
	//void sendVerificationCode(String email);
	//String codeGenerator();
	
	//HRMS v1
	void sendLink(String email);
	String sendCode();
}
