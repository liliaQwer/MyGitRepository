package voting.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import voting.util.User;

@Controller
public class Login {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/sign", method  = GET)
	public String sign(Map<String,Object> map){
		try{
			List<Integer> rolesIdList=jdbcTemplate.query("select * from mydb.roles", new ParameterizedRowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {
					return arg0.getInt("id");
				}
			});
			for (int id:rolesIdList){
				System.out.println(id);
			}
			System.out.println("Get");
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		map.put("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/test", method  = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User  test(){
		System.out.println("test");
		return new User();
	}
	
	/*@RequestMapping(value="/checkUniqueEmail")
	public ResponseEntity checkUniqueEmail(@RequestParam("email") String email){
		System.out.println("post");
		System.out.println(email);
		if (email.contains("li")) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
	}*/
	
	@RequestMapping(value="/checkUniqueEmail")
	public @ResponseBody void checkUniqueEmail(@RequestParam("email") String email, HttpServletResponse response){
		try{
			int emailCount=jdbcTemplate.queryForInt("select count (*) from mydb.users where login=?", email);
			System.out.println("emailCount="+emailCount);
			if (emailCount==0){
				response.setStatus(200);
			}
			response.setStatus(400);
			try {
				response.sendError(400, "not unique email");
			} catch (IOException e) {
				
			}
		}catch (DataAccessException e){
			try {
				response.sendError(400, "something went wrong");
			} catch (IOException e1) {
				response.setStatus(400);
			}
		}
		
	}
	
	@RequestMapping(value="/signIn", method = POST)
	public String signIn(@Valid User user, BindingResult result, Map<String,Object> map){
		if (result.hasErrors()) {
			return "login";
		} else {
			map.put("user",user);
			return "initialPage";
		}	
	}

	@RequestMapping(value="/signUp", method = POST)
	public String signUp(@Valid User user, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "login";
		}
		System.out.println("email="+user.getEmail());
		/*int emailCount=jdbcTemplate.update("insert into mydb.users values(?,?,?,?)", user.getEmail(), role, user.getPassword(), user.getBirthDate());
		if (emailCount==1){
			model.addAttribute(user);
			return "initialPage";
		}*/
		model.addAttribute(user);
		return "initialPage";
	}		
	
}
