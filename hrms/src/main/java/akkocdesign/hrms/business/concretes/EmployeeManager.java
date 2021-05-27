package akkocdesign.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.EmployeeService;
import akkocdesign.hrms.dataAccess.abstracts.EmployeeDao;

@Service("EmployeeManager")
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
}
