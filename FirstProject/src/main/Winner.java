package main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Winner {
	 public Winner(){
		 System.out.println("winner()");
	 }
	
	@Autowired
	@Qualifier("hero1")
	private Hero hero;

	public Hero getHero() {
		return hero;
	}
}
