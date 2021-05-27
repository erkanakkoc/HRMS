package akkocdesign.hrms.business.abstracts;

import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.Employer;

public interface AuthService {
	Result registerEmployer(Employer employer, String confirmedPassword);
	Result registerCandidate(Candidate candidate, String confirmedPassword);
	Result verifyEmail(int user_id, String activationCode);

}
