package akkocdesign.hrms.api.controllers;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.dtos.CandidateCVDto;
import akkocdesign.hrms.business.abstracts.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getCandidateCVById")
	public DataResult<CandidateCVDto> getCandidateCVById(@RequestParam int id){
		return this.candidateService.getCandidateCVById(id);
	}
	
}
