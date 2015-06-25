package voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import voting.dao.AnswerDAO;
import voting.dao.QuestionDAO;
import voting.model.VotingDetails;

@Controller
public class VotingController {
	
	private QuestionDAO questionDAO;
	private AnswerDAO answerDAO;
	
	@Autowired
	public VotingController(QuestionDAO questionDAO, AnswerDAO answerDAO){
		this.questionDAO = questionDAO;
		this.answerDAO = answerDAO;
	}
	
	@RequestMapping("/votingDetails/{id}")
	public ModelAndView showVotingDetails(@PathVariable("id") int id, ModelAndView mv){
		VotingDetails details = questionDAO.getDetailsById(id);
		details.setVotingResult(answerDAO.getResultsByQuestionId(details.getId()));
		mv.addObject(details);
		mv.setViewName("votingDetails");
		return mv;
	}

}
