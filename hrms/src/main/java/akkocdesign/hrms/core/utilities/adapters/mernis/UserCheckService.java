package akkocdesign.hrms.core.utilities.adapters.mernis;

import java.time.LocalDate;

public interface UserCheckService {
	
	//ValidationService yerine UserCheckService i kullandım
	
	//HRMS v3
	//boolean checkIfRealPerson(long nationalityId, String firstName, String lastName,LocalDate dateOfBirth);

	//HRMS v1
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);

}
