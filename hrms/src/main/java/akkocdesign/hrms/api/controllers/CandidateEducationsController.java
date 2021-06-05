package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateEducationService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateEducations")
public class CandidateEducationsController {

	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation){
		return this.candidateEducationService.add(candidateEducation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateEducation candidateEducation){
		return this.candidateEducationService.update(candidateEducation);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.candidateEducationService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateEducation> getById(@RequestParam int id){
		return this.candidateEducationService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateEducation>> getAll(){
		return this.candidateEducationService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<CandidateEducation>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id){
		return this.candidateEducationService.getAllByCandidateIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateEducation>> getAllByJobseekerId(@RequestParam int id){
		return this.candidateEducationService.getAllByCandidateId(id);
	}
}
