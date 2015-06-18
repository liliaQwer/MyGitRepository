package voting.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleException(HttpServletRequest request, DataAccessException e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("exception",e);
		mv.addObject("url", request.getRequestURL());
		return mv;
	}

}
