package main;
import java.util.List;

public class Factory {
	List<Nameble> list;
	public List<Nameble> getList() {
		return list;
	}
	public void setList(List<Nameble> list) {
		System.out.println("setList(..)");
		this.list = list;
	}
	public static Nameble createInstance(int type){
		switch (type) {
		case 1:
			return new Hero("DefaultName");			
		default:
			return new Weapon();
		}
	}

}
