package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.JobAdvertService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody JobAdvert jobAdvert){
		return this.jobAdvertService.add(jobAdvert);
	}

	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){		
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(@RequestParam int id){
		return this.jobAdvertService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList(){
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt(){
		return this.jobAdvertService.findAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(@RequestParam int id){
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
}
