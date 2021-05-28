package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.entities.concretes.Employee;

public interface EmployeeService {
	//HRMS v1
	DataResult<List<Employee>> getAll();
}
