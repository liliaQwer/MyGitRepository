package dbAttempt;

public class FileInfo {
	int messageNum;
	int serviceId;
	
	public FileInfo(){
		
	}
	
	public FileInfo(int messageNum,int serviceId){
		this.messageNum=messageNum;
		this.serviceId=serviceId;
	}
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}    	    

}
