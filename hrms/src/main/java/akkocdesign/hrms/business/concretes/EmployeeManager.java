package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.EmployeeService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.dataAccess.abstracts.EmployeeDao;
import akkocdesign.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
}
