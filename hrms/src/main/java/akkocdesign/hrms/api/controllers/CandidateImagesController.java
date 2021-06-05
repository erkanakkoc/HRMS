package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import akkocdesign.hrms.business.abstracts.CandidateImageService;
import akkocdesign.hrms.business.abstracts.CandidateService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.CandidateImage;

@RestController
@RequestMapping("/api/candidateImages")
public class CandidateImagesController {

	private CandidateImageService candidateImageService;
	private CandidateService candidateService;
	
	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService, CandidateService candidateService) {
		super();
		this.candidateImageService = candidateImageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		CandidateImage candidateImage = new CandidateImage();
		candidateImage.setCandidate(candidate);
		return this.candidateImageService.add(candidateImage, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateImage candidateImage){
		return this.candidateImageService.update(candidateImage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.candidateImageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CandidateImage> getById(@RequestParam("id") int id){
		return this.candidateImageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateImage>> getAll(){
		return this.candidateImageService.getAll();
	}
	
	
	@GetMapping("/getByCandidateId")
	public DataResult<CandidateImage> getByJobseekerId(@RequestParam int id){
		return this.candidateImageService.getByCandidateId(id);
	}
}
