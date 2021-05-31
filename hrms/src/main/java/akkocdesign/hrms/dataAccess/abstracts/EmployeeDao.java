package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employee getById(int id);
}
