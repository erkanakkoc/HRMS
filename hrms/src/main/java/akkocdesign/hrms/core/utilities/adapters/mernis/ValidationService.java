package akkocdesign.hrms.core.utilities.adapters.mernis;

public interface ValidationService {
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);
}
