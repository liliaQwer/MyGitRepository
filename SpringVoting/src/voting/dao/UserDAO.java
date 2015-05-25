package voting.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import voting.model.SignInUser;
import voting.model.SignUpUser;
import voting.util.MD5;
import voting.util.Roles;

@Component
public class UserDAO {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private MD5 mD5;
	
	public boolean isEmailRegistered(String email) throws  DataAccessException{
		int usersCount = jdbcTemplate.queryForInt("select count(*) from mydb.users where login=?", email);
		if (usersCount == 0){
			return false;
		}
		return true;
	}	
		
	public int addNewUser(SignUpUser user, Roles role) throws  DataAccessException{
		int roleId = roleDao.getRoleId(role);
		String md5Password = mD5.getHash(user.getPassword());
		System.out.println(md5Password);
		return jdbcTemplate.update("insert into mydb.users (login, role_id, password, birthDate) values(?,?,?,?)", user.getEmail(), roleId, md5Password, user.getBirthDate());
	}
	
	public boolean isUserRegistered(SignInUser user)  throws  DataAccessException{
		String md5Password = mD5.getHash(user.getPassword());
		int count = jdbcTemplate.queryForInt("select count(*) from mydb.users where login = ? and password = ?", user.getEmail(), md5Password);
		if (count > 0){
			return true;
		}
		return false;
	}
}

