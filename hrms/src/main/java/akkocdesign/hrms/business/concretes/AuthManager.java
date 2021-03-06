package akkocdesign.hrms.business.concretes;

import java.time.LocalDate;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.AuthService;
import akkocdesign.hrms.business.abstracts.EmployerService;
import akkocdesign.hrms.business.abstracts.CandidateService;
import akkocdesign.hrms.business.abstracts.UserService;
import akkocdesign.hrms.business.abstracts.VerificationCodeService;
import akkocdesign.hrms.business.constants.Messages;
import akkocdesign.hrms.core.utilities.adapters.mernis.ValidationService;
import akkocdesign.hrms.core.utilities.results.ErrorResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.core.utilities.verification.VerificationService;
import akkocdesign.hrms.entities.concretes.Employer;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.VerificationCode;

@Service("AuthManager")
public class AuthManager implements AuthService {
	

	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
		

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	


	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult(Messages.missingInformation);
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult(Messages.invalidEmailAddress);
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + Messages.emailIsAlreadyExist);
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult(Messages.passwordsNotMatch);
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult(Messages.registrationSuccessfully);

	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(candidate.getNationalId()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth().getYear()) == false) {
			return new ErrorResult(Messages.notVerifiedNationalIdentity);
		}

		if (!checkIfNullInfoForJobseeker(candidate, confirmPassword)) {

			return new ErrorResult(Messages.missingInformation);
		}

		if (!checkIfExistsTcNo(candidate.getNationalId())) {

			return new ErrorResult(candidate.getNationalId() + Messages.nationalIdentityIsAlreadyExist);
		}

		if (!checkIfEmailExists(candidate.getEmail())) {

			return new ErrorResult(candidate.getEmail() + Messages.emailIsAlreadyExist);
		}

		
		candidateService.add(candidate);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult(Messages.registrationSuccessfully);
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for candidate register ---START---
	
	private boolean checkIfNullInfoForJobseeker(Candidate candidate, String confirmPassword) {

		if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getNationalId() != null
				&& candidate.getDateOfBirth() != null && candidate.getPassword() != null && candidate.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (this.candidateService.getCandidateByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	// Validation for jobSeeker register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}
}