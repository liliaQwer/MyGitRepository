
public class Hero implements Nameble{
	String name;
	public void setName(String name) {
		this.name = name;
	}

	Weapon weapon;
	public Hero(){
		
	}
	
	public Hero(String name){
		this.name=name;
		weapon=new Weapon();
	}
	public Hero(String name, Weapon weapon){
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
}
