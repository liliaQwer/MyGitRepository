
public class ExcelInfo {
	String fio;
	protected Long phone;
	public ExcelInfo() {
		// TODO Auto-generated constructor stub 
		
	}
		
	public ExcelInfo(String fio,long phone) {
		this.fio=fio;
		this.phone=phone;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String  toString(){
		return phone+" "+fio;
	}
}
