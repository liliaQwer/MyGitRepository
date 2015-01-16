package main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Winner {
	 public Winner(){
		 System.out.println("winner()");
	 }
	
	@Autowired
	@Qualifier("hero1")
	private ActionAware hero;

	public ActionAware getHero() {
		return hero;
	}
}
