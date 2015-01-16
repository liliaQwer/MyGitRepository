package main;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		System.out.println("Поехали");
		ApplicationContext cntx=new ClassPathXmlApplicationContext("core.xml");
		System.out.println("Загрузили контекст");
		ActionAware hero1=cntx.getBean("hero1", ActionAware.class);
		hero1.action();
		/*Hero hero2=cntx.getBean("hero2", Hero.class);
		hero2.action();
		Hero hero3=cntx.getBean("hero2", Hero.class);
		hero3.action();
		hero2.setName("Tetst");
		hero3.action();
		Hero hero4=cntx.getBean("hero3", Hero.class);
		hero4.action();*/
		Nameble someInstance=(Nameble)cntx.getBean("testInstance");
		System.out.println(someInstance.getName());
		Factory factory=cntx.getBean("listTest",Factory.class);
		System.out.println("List example");
		for(Nameble n: factory.getList()){
			System.out.println(n.getName());
		}
		cntx.getBean("winner",Winner.class).getHero().actionWithArg("Мои мыслишки");
		
	}

}
