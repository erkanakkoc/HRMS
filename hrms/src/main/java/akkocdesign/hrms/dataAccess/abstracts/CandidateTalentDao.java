package akkocdesign.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateTalent;

public interface CandidateTalentDao extends JpaRepository<CandidateTalent, Integer>{
	CandidateTalent getById(int id);
	List<CandidateTalent> getAllByCandidate_id(int id);
}
