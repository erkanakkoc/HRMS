package akkocdesign.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate extends User{
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="national_identity")
	private String nationalIdentity;
	
	@Column(name ="birth_date")
	private Date birthDate;

	public Candidate(int id, String email, String password, String firstName, String lastName, String nationalIdentity,
			Date birthDate) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.birthDate = birthDate;
	}
	
}
