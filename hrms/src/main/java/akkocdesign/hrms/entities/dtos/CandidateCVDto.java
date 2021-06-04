package akkocdesign.hrms.entities.dtos;

import java.util.List;

import akkocdesign.hrms.entities.concretes.Candidate;
import akkocdesign.hrms.entities.concretes.CandidateEducation;
import akkocdesign.hrms.entities.concretes.CandidateImage;
import akkocdesign.hrms.entities.concretes.CandidateJobExperience;
import akkocdesign.hrms.entities.concretes.CandidateLanguage;
import akkocdesign.hrms.entities.concretes.CandidateLink;
import akkocdesign.hrms.entities.concretes.CandidateTalent;

public class CandidateCVDto {
	public Candidate candidate;
	public List<CandidateEducation> educations;
	public List<CandidateTalent> talents;
	public List<CandidateLink> links;
	public List<CandidateLanguage> languages;
	public List<CandidateJobExperience> experiences;
	public CandidateImage image;
}
