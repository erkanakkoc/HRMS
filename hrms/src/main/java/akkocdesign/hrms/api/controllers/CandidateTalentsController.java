package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateTalentService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateTalent;

@RestController
@RequestMapping("/api/candidateTalents")
public class CandidateTalentsController {
	private CandidateTalentService candidateTalentService;

	@Autowired
	public CandidateTalentsController(CandidateTalentService candidateTalentService) {
		super();
		this.candidateTalentService = candidateTalentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateTalent candidateTalent){
		return this.candidateTalentService.add(candidateTalent);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateTalent candidateTalent){
		return this.candidateTalentService.update(candidateTalent);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateTalentService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateTalent> getById(@RequestParam("id") int id){
		return this.candidateTalentService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateTalent>> getAll(){
		return this.candidateTalentService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateTalent>> getAllByCandidateId(@RequestParam int id){
		return this.candidateTalentService.getAllByCandidateId(id);
	}
}
