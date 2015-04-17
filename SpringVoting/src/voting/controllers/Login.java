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
	
	@RequestMapping(value="/signIn", method = POST)
	public String signIn(String email, String password, Map<String,Object> map){
		System.out.println("email="+email);
		//return "viewCreatedVotings";
		return "initialPage";
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
