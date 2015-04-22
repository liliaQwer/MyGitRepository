package voting.controllers;

import java.util.Map;

import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import voting.util.User;

@Controller
public class Login {
	
	@RequestMapping(value="/sign")
	public String sign(Map<String,Object> map){
		map.put("user", new User());
		return "login";
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
