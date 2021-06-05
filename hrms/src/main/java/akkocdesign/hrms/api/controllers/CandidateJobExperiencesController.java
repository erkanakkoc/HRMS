package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateJobExperienceService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateJobExperience;

@RestController
@RequestMapping("/api/candidateJobExperiences")
public class CandidateJobExperiencesController {
	private CandidateJobExperienceService candidateJobExperienceService;

	@Autowired
	public CandidateJobExperiencesController(CandidateJobExperienceService candidateJobExperienceService) {
		super();
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobExperience candidateJobExperience){
		return this.candidateJobExperienceService.add(candidateJobExperience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateJobExperience candidateJobExperience){
		return this.candidateJobExperienceService.update(candidateJobExperience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateJobExperienceService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateJobExperience> getById(@RequestParam int id){
		return this.candidateJobExperienceService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateJobExperience>> getAll(){
		return this.candidateJobExperienceService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<CandidateJobExperience>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.candidateJobExperienceService.getAllByCandidateIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<CandidateJobExperience>> getAllByJobseekerId(@RequestParam int id){
		return this.candidateJobExperienceService.getAllByCandidateId(id);
	}

}
