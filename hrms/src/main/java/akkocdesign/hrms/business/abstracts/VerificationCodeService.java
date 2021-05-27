package akkocdesign.hrms.business.abstracts;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
	Result update(VerificationCode code);
	DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	

}
