package voting.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import voting.dao.UserDAO;
import voting.daoManagers.UserManager;
import voting.model.SignInUser;
import voting.model.SignUpUser;
import voting.util.Constants;
import voting.util.Roles;

@Controller
public class MainController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserManager userManager;
	@Autowired
	private AuthenticationManager authManager;
	
	
	@RequestMapping(value="/sign", method  = GET)
	public ModelAndView sign(@RequestParam(value="error", required = false) String error, HttpSession session){		
		ModelAndView model = new ModelAndView();
		SignInUser signInUser = new SignInUser();		
		if (error != null) {
			signInUser.setEmail(session.getAttribute("LAST_USERNAME").toString());
			session.removeAttribute(Constants.LAST_USERNAME);
			model.addObject("errorLogin", "Username or password is not correct");
		}
		model.addObject("signInUser", signInUser);
		model.addObject("signUpUser", new SignUpUser());
		model.setViewName("login");
		return model;	
		
		}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(){
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)){
			model.addObject("login", auth.getName());
		}
		model.setViewName("403");
		return model;
	}
	
	

	@RequestMapping(value="/signUp", method = POST)
	public String signUp(@Valid SignUpUser user, BindingResult result, Model model,HttpServletRequest request){
		if (result.hasErrors()) {
			model.addAttribute("tab", "registration");
			model.addAttribute("signInUser", new SignInUser());
			return "login";
		}
		try{
			userManager.addNewUser(user, Roles.USER);		
		}catch (DataAccessException e){
			e.printStackTrace();
			model.addAttribute("tab", "registration");
			model.addAttribute("signInUser", new SignInUser());
			model.addAttribute("error", "something went wrong");
			return "login";
		}
		authenticateUserAndSetSession(user, request);		
		return "initialPage";
	}	
		
	 private void authenticateUserAndSetSession(SignUpUser user, HttpServletRequest request) {
		 String username = user.getEmail();
	     String password = user.getPassword();
	     UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

	     // generate session if one doesn't exist
	     request.getSession();

	     token.setDetails(new WebAuthenticationDetails(request));
	     Authentication authenticatedUser = authManager.authenticate(token);
	     SecurityContextHolder.getContext().setAuthentication(authenticatedUser);	        
	    }
	 
	
}
	
