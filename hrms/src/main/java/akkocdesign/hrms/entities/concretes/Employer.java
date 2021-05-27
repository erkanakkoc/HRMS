package akkocdesign.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false) 
@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")

public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="is_email_verified")
	private Boolean isEmailVerified;
    
    @Column(name="is_verified_by_emlopyee")
	private Boolean isVerifiedByEmlopyee;

}
