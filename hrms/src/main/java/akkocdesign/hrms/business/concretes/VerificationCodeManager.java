package akkocdesign.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.VerificationCodeService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.VerificationCodeDao;
import akkocdesign.hrms.entities.concretes.VerificationCode;

@Service("VerificationCodeManager")
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	
	
	
	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code added!");
	}

	@Override
	public Result update(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code updated!");
	}

	@Override
	public DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	}

}
