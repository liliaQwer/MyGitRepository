package voting.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import voting.util.User;

@Controller
public class Login {
	
	@RequestMapping(value="/sign", method  = GET)
	public String sign(Map<String,Object> map){
		System.out.println("Get");
		map.put("user", new User());
		return "login";
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
		System.out.println(email);
		if (email.contains("li")) {
			response.setStatus(200);			
		} else {
			response.setStatus(400);			
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
		System.out.println("email="+user.getEmail());
		if (result.hasErrors()) {
			return "login";
		} else {
			model.addAttribute(user);
			return "initialPage";
		}		
	}
}
