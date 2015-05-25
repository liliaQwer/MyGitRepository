package voting.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import voting.dao.UserDAO;
import voting.model.SignInUser;
import voting.model.SignUpUser;
import voting.util.Roles;
import voting.util.User;

@Controller
public class Login {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/sign", method  = GET)
	public String sign(Map<String,Object> map){		
		map.put("signInUser", new SignInUser());
		map.put("signUpUser", new SignUpUser());
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
		if (userDAO.isEmailRegistered(email)){
			response.setStatus(400);			
		}else{
			response.setStatus(200);
		}
		
	}
	
	@RequestMapping(value="/signIn", method = POST)
	public String signIn(@Valid SignInUser user, BindingResult result, Map<String,Object> map){		
		if (result.hasErrors()) {
			map.put("signUpUser", new SignUpUser());
			map.put("tab", "login");
			return "login";
		}
		try{
			if (!userDAO.isUserRegistered(user)){
				map.put("signUpUser", new SignUpUser());
				map.put("tab", "login");
				map.put("error", "login or password is not correct");
				return "login";
			}
		}catch(DataAccessException e){
			map.put("error", "something went wrong");
			return "login";
		}
		
		return "initialPage";
			
	}

	@RequestMapping(value="/signUp", method = POST)
	public String signUp(@Valid SignUpUser user, BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("signInUser", new SignInUser());
			model.addAttribute("tab", "registration");
			return "login";
		}
		try{
			userDAO.addNewUser(user, Roles.AUTHORIZED);		
		}catch (DataAccessException e){
			model.addAttribute("signInUser", new SignInUser());
			model.addAttribute("error", "something went wrong");
			model.addAttribute("tab", "registration");
			return "login";
		}
		return "initialPage";
	}		
	
}
