package akkocdesign.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import akkocdesign.hrms.business.abstracts.JobPositionService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition){
		return this.jobPositionService.add(jobPosition);
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
}
