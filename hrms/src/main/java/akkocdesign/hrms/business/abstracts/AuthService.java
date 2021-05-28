package akkocdesign.hrms.business.abstracts;

import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.Employer;

public interface AuthService {
	
	//HRMS v3
	
//	Result registerEmployer(Employer employer, String confirmedPassword);
//	Result registerCandidate(Candidate candidate, String confirmedPassword);
//	Result verifyEmail(int user_id, String activationCode);

	//HRMS v1
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobseeker(Candidate candidate, String confirmPassword);
}
