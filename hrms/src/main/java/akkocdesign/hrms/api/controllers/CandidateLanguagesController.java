package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.CandidateLanguageService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguagesController {
	
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage){
		return this.candidateLanguageService.add(candidateLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateLanguage candidateLanguage){
		return this.candidateLanguageService.update(candidateLanguage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateLanguageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateLanguage> getById(@RequestParam("id") int id){
		return this.candidateLanguageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateLanguage>> getAll(){
		return this.candidateLanguageService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(@RequestParam int id){
		return this.candidateLanguageService.getAllByCandidateId(id);
	}

}
