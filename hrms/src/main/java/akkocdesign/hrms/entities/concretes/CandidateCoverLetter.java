package akkocdesign.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_cover_letters")
@NoArgsConstructor
public class CandidateCoverLetter extends Base{
	
	@Column(name = "content")
	private String content;
	
	public CandidateCoverLetter(String content, int candidateId) {
		super();
		this.content = content;
		this.candidate.setId(candidateId);
	}

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;
	
}