package voting.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import voting.dao.QuestionDAO;
import voting.dao.UserDAO;
import voting.model.ActiveVotings;
import voting.model.SignInUser;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired 
	private QuestionDAO questionDAO;
	
	@RequestMapping(value="/checkUniqueEmail")
	public void checkUniqueEmail(String email, HttpServletResponse response){
		if (userDAO.isLoginRegistered(email)){
			response.setStatus(400);			
		}else{
			response.setStatus(200);
		}
		
	}
	
	@RequestMapping(value="/getActiveVoting", method  = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ActiveVotings getActiveVoting(int page){
		ActiveVotings model = new ActiveVotings();
		model.setVotingList(questionDAO.getActiveVoting());
		int itemsCount = model.getVotingList().size();
		int pageSize = 15;
		int pageCount = ((float)itemsCount/pageSize - itemsCount/pageSize)>0 ? itemsCount/pageSize + 1 : itemsCount/pageSize;
		model.setMaxPage(pageCount);
		model.setCurrentPage(page);
		return model;
	}
	
	@RequestMapping("/getTotalVoting")
	@ResponseBody
	public int getTotalVoting(){
		return questionDAO.getActiveVotingCount();
	}
	/*@RequestMapping(value="/test", method  = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User  test(){
		System.out.println("test");
		return new User();
	}*/
		
	@RequestMapping(value="/test")
	public void  test(@ModelAttribute("login") String login){
		System.out.println(login);
		
	}

}
