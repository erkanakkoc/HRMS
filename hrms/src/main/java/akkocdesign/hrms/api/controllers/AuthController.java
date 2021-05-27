package akkocdesign.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.AuthService;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@GetMapping("/verify")
	public Result verify(int userId, String verificationCode) {
		return this.authService.verifyEmail(userId, verificationCode);
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
		return this.authService.registerCandidate(candidate, confirmPassword);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
	}
}
