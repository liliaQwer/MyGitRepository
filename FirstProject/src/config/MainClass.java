package config;

import main.Hero;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext cntx=new ClassPathXmlApplicationContext("configWithoutXml.xml");
		Hero hero1=cntx.getBean("myFirstHero",Hero.class);
		hero1.action();
	}

}
