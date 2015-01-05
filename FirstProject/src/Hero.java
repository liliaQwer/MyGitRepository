import org.springframework.beans.factory.BeanNameAware;


public class Hero implements Nameble,BeanNameAware{
	String name;
	String beanName;
	
	public void setName(String name) {
		System.out.println("setName("+name+")");
		this.name = name;
	}

	Weapon weapon;
	public Hero(){
		System.out.println("Hero()");
	}
	
	public Hero(String name){
		System.out.println("Hero("+name+")");
		this.name=name;
		weapon=new Weapon();
	}
	public Hero(String name, Weapon weapon){
		System.out.println("Hero("+name+", Weapon "+weapon+")");
		this.name=name;
		this.weapon=weapon;
	}
	public void action (){
		System.out.println("My name is " + name);
		if(weapon!=null){
			System.out.println("I have "+weapon.getName());
		}		
		System.out.println("I will save princess");
	}
	@Override
	public String getName() {
		return name;
	}

	public void wakeUp(){
		System.out.println("I wake up");
	}
	
	public void sleep(){
		System.out.println("I go to sleep");
	}

	public void setWeapon(Weapon weapon) {
		System.out.println("setWeapon( Weapon "+weapon+")");
		this.weapon = weapon;
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName "+arg0);
		beanName=arg0;
	}
}
