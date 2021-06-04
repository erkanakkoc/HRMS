package akkocdesign.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer>{
	CandidateLink getById(int id);
	List<CandidateLink> getAllByCandidate_id(int id);
}
