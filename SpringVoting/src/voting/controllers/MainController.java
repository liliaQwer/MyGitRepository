package voting.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import voting.dao.UserDAO;
import voting.model.SignInUser;
import voting.model.SignUpUser;
import voting.util.Roles;
import voting.util.User;

@Controller
public class MainController {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	AuthenticationManager authManager;
	
	@RequestMapping(value="/sign", method  = GET)
	public ModelAndView sign(@RequestParam(value="error", required = false) String error , HttpSession session){		
		ModelAndView model = new ModelAndView();
		SignInUser signInUser = new SignInUser();		
		if (error != null) {
			signInUser.setEmail(session.getAttribute("LAST_USERNAME").toString());
			session.removeAttribute("LAST_USERNAME");
			model.addObject("error", "Username or password is not correct");
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
	
	@RequestMapping(value="/test", method  = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User  test(){
		System.out.println("test");
		return new User();
	}
		
	@RequestMapping(value="/checkUniqueEmail")
	public @ResponseBody void checkUniqueEmail(@RequestParam("email") String email, HttpServletResponse response){
		if (userDAO.isLoginRegistered(email)){
			response.setStatus(400);			
		}else{
			response.setStatus(200);
		}
		
	}
	
	/*@RequestMapping(value="/signIn", method = POST)
	public String signIn(@Valid SignInUser user, BindingResult result, Map<String,Object> map){		
		SignModel model = new SignModel();
		System.out.println("email:"+user.getEmail());
		System.out.println("in signIn");
		if (result.hasErrors()) {
			System.out.println("in.hasErrors");
			map.put("model", model);
			return "login";
		}
		try{
			if (!userDAO.isUserRegistered(user)){
				map.put("model", model);
				map.put("error", "login or password is not correct");
				return "login";
			}
		}catch(DataAccessException e){
			map.put("error", "something went wrong");
			return "login";
		}
		
		return "initialPage";
			
	}*/

	@RequestMapping(value="/signUp", method = POST)
	public String signUp(@Valid SignUpUser user, BindingResult result, Model model,HttpServletRequest request){
		System.out.println("email:"+user.getEmail());
		System.out.println("in signUp");
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			System.out.println("in.hasErrors");
			model.addAttribute("tab", "registration");
			model.addAttribute("signInUser", new SignInUser());
			return "login";
		}
		try{
			System.out.println("in.addNewUser");
			userDAO.addNewUser(user, Roles.USER);		
		}catch (DataAccessException e){
			e.printStackTrace();
			model.addAttribute("tab", "registration");
			model.addAttribute("signInUser", new SignInUser());
			model.addAttribute("error", "something went wrong");
			return "login";
		}
		System.out.println("before authenticateUserAndSetSession");
		authenticateUserAndSetSession(user, request);
		
		System.out.println("authorities " +request.isUserInRole("ROLE_user"));
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println("they are "+authorities);
		return "initialPage";
	}		
	
	 private void authenticateUserAndSetSession(SignUpUser user, HttpServletRequest request) {
		 System.out.println("in authenticateUserAndSetSession");
	        String username = user.getEmail();
	        String password = user.getPassword();
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

	        // generate session if one doesn't exist
	        request.getSession();

	        token.setDetails(new WebAuthenticationDetails(request));
	        System.out.println("before  authManager.authenticate");
	        Authentication authenticatedUser = authManager.authenticate(token);
	        System.out.println("after  authManager.authenticate");
	        
	        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	        System.out.println("finich authenticateUserAndSetSession");
	    }
	 
	
}
	
