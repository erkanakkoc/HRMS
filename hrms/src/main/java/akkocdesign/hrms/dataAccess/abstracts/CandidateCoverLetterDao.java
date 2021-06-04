package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.CandidateCoverLetter;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter, Integer> {
	CandidateCoverLetter getById(int id);
}
