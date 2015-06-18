package voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import voting.dao.AnswerDAO;
import voting.dao.QuestionDAO;
import voting.model.VotingDetails;

@Controller
public class VotingController {
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private AnswerDAO answerDAO;
	
	@RequestMapping("votingDetails")
	public ModelAndView showVotingDetails(@RequestParam int id){
		ModelAndView mv=new ModelAndView("votingDetails");
		VotingDetails details = new VotingDetails();
		details.setId(id);
		questionDAO.fillDetails(details);
		details.setVotingResult(answerDAO.getResultsByQuestionId(details.getId()));
		mv.addObject(details);
		return mv;
	}

}
