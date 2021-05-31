package akkocdesign.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false) 
@Data
@Entity
// @PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	//HRMS v3
//	@Column(name = "web_site")
//	private String webSite;
	
//	@Column(name="is_email_verified")
//	private Boolean isEmailVerified;
    
//    @Column(name="is_verified_by_emlopyee")
//	private Boolean isVerifiedByEmlopyee;
    
    
    //HRMS V1

	@Column(name= "website")
	private String website;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;

}
