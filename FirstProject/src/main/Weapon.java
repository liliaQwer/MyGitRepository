package main;

public class Weapon implements Nameble{
	String name;
	
	public Weapon(){
		System.out.println("Weapon()"+this);
		name="bow";
	}
	public Weapon (String name){
		System.out.println("Weapon("+name+")"+this);
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	
}
