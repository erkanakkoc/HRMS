package akkocdesign.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akkocdesign.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	//HRMS V1
	User findUserByEmail(String email);
	User getById(int id);
}
