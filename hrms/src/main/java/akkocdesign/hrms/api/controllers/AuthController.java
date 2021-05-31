package akkocdesign.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.AuthService;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Employer;
import akkocdesign.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody Employer employer, String confirmPassword)
	{
		return authService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registerJobseeker")
	public Result registerJobseeker(@RequestBody JobSeeker jobSeeker, String confirmPassword)
	{
		return authService.registerJobSeeker(jobSeeker, confirmPassword);
	}
}
