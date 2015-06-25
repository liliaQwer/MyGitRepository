import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import voting.dao.AnswerDAO;
import voting.dao.QuestionDAO;

@Configuration
public class TestContext {
	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
 
        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
 
        return messageSource;
    }
 
    @Bean
    public QuestionDAO questionService() {
        return Mockito.mock(QuestionDAO.class);
    }
    
    @Bean
    public AnswerDAO answerService() {
        return Mockito.mock(AnswerDAO.class);
    }
}
