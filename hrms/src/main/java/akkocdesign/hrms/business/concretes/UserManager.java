package akkocdesign.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akkocdesign.hrms.business.abstracts.UserService;
import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.core.utilities.results.Result;
import akkocdesign.hrms.core.utilities.results.SuccessDataResult;
import akkocdesign.hrms.core.utilities.results.SuccessResult;
import akkocdesign.hrms.dataAccess.abstracts.UserDao;
import akkocdesign.hrms.entities.concretes.User;

@Service("UserManager")
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
	    return new SuccessResult("User has been added.");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}
	
	
}
