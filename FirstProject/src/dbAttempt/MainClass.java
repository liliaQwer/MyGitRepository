package dbAttempt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args){
		ApplicationContext cntx=new ClassPathXmlApplicationContext("configWithDb.xml");
		MyDAO obj=cntx.getBean("myDao",MyDAO.class);
		obj.addFile(new FileInfo(1,100));
	}

}
