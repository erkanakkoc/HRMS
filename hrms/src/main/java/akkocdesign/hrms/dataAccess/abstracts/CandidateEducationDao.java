package akkocdesign.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer> {
	CandidateEducation getById(int id);
	List<CandidateEducation> getAllByCandidate_idOrderByEndAtDesc(int id);
	List<CandidateEducation> getAllByCandidate_id(int id);
}
