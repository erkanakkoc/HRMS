package akkocdesign.hrms.core.utilities.adapters.mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import akkocdesign.hrms.mernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService{

	//HRMS v3
	
//	@Override
//	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
	       
//		FakeMernisService client= new FakeMernisService();
		
//		boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, dateOfBirth);
		

//		return result;
//	}

	//HRMS v1
	@Override
	public boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth) {

		FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalId, firstName, lastName, yearOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}


}
