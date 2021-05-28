package akkocdesign.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
//HRMS V3
//@Table(name="job_titles")

//HRMS v1
@Table(name="job_positions")

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="is_active",columnDefinition = "boolean default true")
	private Boolean isActive =true;
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted=false;
	
	//HRMS V3
	
//	@Column(name="title_name")
//	private String titleName;
	
//	@Column(name = "description")
//	private String description;
	
//	@Column(name="created_date",columnDefinition = "Date default CURRENT_DATE")
//	private LocalDate createdDate=LocalDate.now();
	
	//HRMS V1

	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name= "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

}
