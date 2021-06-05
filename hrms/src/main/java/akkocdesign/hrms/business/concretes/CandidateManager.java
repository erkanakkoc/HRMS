package akkocdesign.hrms.business.concretes;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.CandidateEducationService;
import akkocdesign.hrms.business.abstracts.CandidateImageService;
import akkocdesign.hrms.business.abstracts.CandidateJobExperienceService;
import akkocdesign.hrms.business.abstracts.CandidateLanguageService;
import akkocdesign.hrms.business.abstracts.CandidateLinkService;
import akkocdesign.hrms.business.abstracts.CandidateService;
import akkocdesign.hrms.business.abstracts.CandidateTalentService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.CandidateDao;
import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.dtos.CandidateCVDto;
import net.bytebuddy.asm.Advice.This;

@Service("CandidateManager")
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private CandidateJobExperienceService candidateJobExperienceService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateImageService candidateImageService;
	private CandidateLinkService candidateLinkService;
	private CandidateTalentService candidateTalentService;
	private CandidateEducationService candidateEducationService;

	public CandidateManager(CandidateDao candidateDao, CandidateJobExperienceService candidateJobExperienceService,
			CandidateLanguageService candidateLanguageService, CandidateImageService candidateImageService,
			CandidateLinkService candidateLinkService, CandidateTalentService candidateTalentService,
			CandidateEducationService candidateEducationService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateJobExperienceService = candidateJobExperienceService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateImageService = candidateImageService;
		this.candidateLinkService = candidateLinkService;
		this.candidateTalentService = candidateTalentService;
		this.candidateEducationService = candidateEducationService;
	}

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
	      return new SuccessResult("Candidate has been added.");
	}
	
	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Candidate has been deleted.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalId(nationalId));
	}



	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	@Override
	public DataResult<CandidateCVDto> getCandidateCVById(int id) {
		Candidate candidate = this.candidateDao.getById(id);
		CandidateCVDto cv = new CandidateCVDto();
		cv.experiences = candidate.getJobExperiences();
		cv.languages = candidate.getLanguages();
		cv.image = candidate.getImage();
		cv.links = candidate.getLinks();
		cv.talents = candidate.getTalents();
		cv.educations = candidate.getEducations();
		return new SuccessDataResult<CandidateCVDto>(cv);
	}
	
	
}
