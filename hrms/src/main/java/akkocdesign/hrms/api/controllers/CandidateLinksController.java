package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateLinkService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidateLinks")
public class CandidateLinksController {
	
	private CandidateLinkService candidateLinkService;

	@Autowired
	public CandidateLinksController(CandidateLinkService candidateLinkService) {
		super();
		this.candidateLinkService = candidateLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLink candidateLink){
		return this.candidateLinkService.add(candidateLink);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateLink candidateLink){
		return this.candidateLinkService.update(candidateLink);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateLinkService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateLink> getById(@RequestParam("id") int id){
		return this.candidateLinkService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateLink>> getAll(){
		return this.candidateLinkService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateLink>> getAllByCandidateId(@RequestParam int id){
		return this.candidateLinkService.getAllByCandidateId(id);
	}
}
