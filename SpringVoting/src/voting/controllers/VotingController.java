package voting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import voting.model.VotingDetails;

@Controller
public class VotingController {
	
	@RequestMapping("votingDetails")
	public ModelAndView showVotingDetails(@RequestParam int id){
		ModelAndView mv=new ModelAndView("votingDetails");
		mv.addObject(new VotingDetails());
		return mv;
	}

}
