package akkocdesign.hrms.api.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateCoverLetterService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateCoverLetter;

@RestController
@RequestMapping("/api/candidateCoverLetters")
public class CandidateCoverLettersController {
	
	private CandidateCoverLetterService candidateCoverLetterService;

	@Autowired
	public CandidateCoverLettersController(CandidateCoverLetterService candidateCoverLetterService) {
		super();
		this.candidateCoverLetterService = candidateCoverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCoverLetter candidateCoverLetter){
		return this.candidateCoverLetterService.add(candidateCoverLetter);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateCoverLetter candidateCoverLetter){
		return this.candidateCoverLetterService.update(candidateCoverLetter);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateCoverLetterService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateCoverLetter> getById(@RequestParam("id") int id){
		return this.candidateCoverLetterService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateCoverLetter>> getAll(){
		return this.candidateCoverLetterService.getAll();
	}
}
