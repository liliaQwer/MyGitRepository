package config;

import main.Hero;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Bean
	public Hero myFirstHero(){
		return new Hero();
	}

}
