package dbAttempt;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args){
		ApplicationContext cntx=new ClassPathXmlApplicationContext("configWithDb.xml");
		MyDAO dao=cntx.getBean("myDao",MyDAO.class);
		dao.addFile(new FileInfo(1,110));
		FileInfo f=dao.getFileInfoByServId(110);
		System.out.println(f.getMessageNum());
		System.out.println(f.getServiceId());
	}

}
