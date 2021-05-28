package akkocdesign.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@NoArgsConstructor
@AllArgsConstructor

//	HRMS V1
@Table(name = "jobseekers")

// HRMS V3
// @Table(name = "candidates")
public class Candidate extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	//HRMS V3
//	@Column(name = "nationality_id")
//	private String nationalityId;
	
//	@Column(name = "is_verified_by_email")
//	private Boolean isEmailVerified;
	
	
	//HRMS V1
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	
	
	
	
}
