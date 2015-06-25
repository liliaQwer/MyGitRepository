package voting.controllrs;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import voting.builder.VotingDetailsBuilder;
import voting.controllers.VotingController;
import voting.dao.AnswerDAO;
import voting.dao.QuestionDAO;
import voting.model.VotingDetails;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/testContext.xml","file:WebContent/WEB-INF/security.xml","file:WebContent/WEB-INF/voting-servlet.xml"})
@WebAppConfiguration
public class VotingControllerTest {

	private MockMvc mockMvc;
	
	@Resource
    private FilterChainProxy springSecurityFilterChain;
	
	@Autowired
	private QuestionDAO questionDaoMock;
	@Autowired
	private AnswerDAO answerDaoMock;
	 @Autowired
	    private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		Mockito.reset(questionDaoMock);
		Mockito.reset(answerDaoMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain).build();
	    /* mockMvc = MockMvcBuilders.standaloneSetup(new VotingController(questionDaoMock, answerDaoMock))
	              .setViewResolvers(viewResolver())
	              .addFilter(springSecurityFilterChain)
	              .build();*/
	     
	} 
 
    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
    
    @Test
    public void showVotingDetails_shouldAddDetailsToModelAndRenderDetailsView() throws Exception{
    	int id = 1;
    	Date curDate = new Date(new java.util.Date().getTime());
    	VotingDetails details = new VotingDetailsBuilder().withId(id).withCreateDate(curDate).build();
    	if (questionDaoMock == null) System.out.println("NULLLL");
    	when(questionDaoMock.getDetailsById(id)).thenReturn(details);
    	mockMvc.perform(get("/votingDetails/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("votingDetails"))
                .andExpect(forwardedUrl("/pages/votingDetails.jsp"))
                .andExpect(model().attribute("votingDetails", hasProperty("id", is(id))))
                .andExpect(model().attribute("votingDetails", hasProperty("createDate", is(curDate))));
 
        verify(questionDaoMock, times(1)).getDetailsById(id);
        verifyNoMoreInteractions(questionDaoMock);
    	
    	
    }
}
