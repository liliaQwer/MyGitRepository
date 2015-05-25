package voting.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import voting.util.Roles;

@Component
public class RoleDAO {
	@Autowired
	SimpleJdbcTemplate jdbcTemplate;
	
	public int getRoleId(Roles role) throws DataAccessException{
		String query="select id from mydb.roles where role=?";
		switch (role) {
		case ADMIN:
			return jdbcTemplate.queryForInt(query, "admin");			
		case MODERATOR:
			return jdbcTemplate.queryForInt(query, "moderator");
		case AUTHORIZED:
			return jdbcTemplate.queryForInt(query, "authorized");
		default:
			return jdbcTemplate.queryForInt(query, "anonym");		
		}
	}

}
