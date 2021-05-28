package akkocdesign.hrms.mernisService;

import java.time.LocalDate;

public class FakeMernisService {

	//HMRS V3
	//public boolean TCKimlikDogrula(long TCKimlikNo, java.lang.String ad, java.lang.String soyad, LocalDate dogumYili) {
	//	return true;
	//}
	
	//HRMS V1
	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
}
