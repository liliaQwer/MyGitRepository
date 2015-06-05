package voting.daoManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import voting.dao.UserDAO;
import voting.model.SignUpUser;
import voting.util.Roles;

@Component
public class UserManager {
	@Autowired
	private UserDAO userDao;
		
	@Transactional
	public int addNewUser(SignUpUser user, Roles role){
		return userDao.addNewUser(user, role);
	}

}
