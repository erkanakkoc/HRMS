package akkocdesign.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{
	CandidateLanguage getById(int id);
	List<CandidateLanguage> getAllByCandidate_id(int id);
}
