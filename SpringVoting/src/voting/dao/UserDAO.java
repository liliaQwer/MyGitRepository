package voting.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import voting.model.SignUpUser;
import voting.util.Roles;

@Component
public class UserDAO {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	
	public boolean isLoginRegistered(String email) throws  DataAccessException{
		int usersCount = jdbcTemplate.queryForInt("select count(*) from mydb.users where login=?", email);
		if (usersCount == 0){
			return false;
		}
		return true;
	}	
	
	
	public int addNewUser(SignUpUser user, Roles role) throws  DataAccessException{
		int result = jdbcTemplate.update("insert into mydb.users (login,  password, birthDate) values(?,?,?)", user.getEmail(), user.getPassword(), user.getBirthDate());
		result += jdbcTemplate.update("insert into mydb.user_roles (login, role) values(?,?)", user.getEmail(), "user");
		return result;
	}
	
	
}

