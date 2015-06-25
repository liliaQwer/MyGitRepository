package voting.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import voting.util.Constants;

public class UserNameCachingAuthenticationFailureHandler  extends SimpleUrlAuthenticationFailureHandler{
	
	@Autowired
	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    	super.onAuthenticationFailure(request, response, exception);
    	String usernameParameter = usernamePasswordAuthenticationFilter.getUsernameParameter();
	    String userName = request.getParameter(usernameParameter);
	    HttpSession session = request.getSession(false);
	    if (session != null || isAllowSessionCreation()) {
	    	System.out.println("onAuthenticationFailure");
	    	request.getSession().setAttribute(Constants.LAST_USERNAME, userName);
	    }
    }
}
