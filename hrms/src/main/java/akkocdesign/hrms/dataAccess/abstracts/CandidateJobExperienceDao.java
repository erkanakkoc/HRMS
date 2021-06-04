package akkocdesign.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer> {
	CandidateJobExperience getById(int id);
	List<CandidateJobExperience> getAllByCandidate_idOrderByEndAtDesc(int id);
	List<CandidateJobExperience> getAllByCandidate_id(int id);
}
