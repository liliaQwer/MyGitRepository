package voting.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import voting.util.User;

public class VotingDetails {
	
	int id=1;
	Date createDate;
	Date endDate;
	String createDateStr="01.01.2010";
	String endDateStr="01.02.2010";
	boolean enabled;
	int remainDaysCount;
	int votesCount=5;
	String question="Надо ли путешествовать?";
	ArrayList<String> commentsList;
	ArrayList<User> votersList;
	VotingResult votingResult=new VotingResult();
	SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		
	public int getVotesCount() {
		return votesCount;
	}
	public void setVotesCount(int votesCount) {
		this.votesCount = votesCount;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(ArrayList<String> commentsList) {
		this.commentsList = commentsList;
	}
	public ArrayList<User> getVotersList() {
		return votersList;
	}
	public void setVotersList(ArrayList<User> votersList) {
		this.votersList = votersList;
	}
	public VotingResult getVotingResult() {
		return votingResult;
	}
	public void setVotingResult(VotingResult votingResult) {
		this.votingResult = votingResult;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEnabled() {
		if(endDate == null){
			return true;
		}
		Calendar calend= Calendar.getInstance();
		if (calend.getTime().equals(endDate) || calend.getTime().after(endDate)){
			return false;
		}else{
			return true;
		}		
	}	
	public int getRemainDaysCount() {
		if(endDate == null){
			return 0;
		}
		java.util.Date curDate = new java.util.Date();
		remainDaysCount= (int)(endDate.getTime()-curDate.getTime())/ (1000 * 60 * 60 * 24);
		return remainDaysCount;
	}
	public void setRemainDaysCount(int remainDaysCount) {
		this.remainDaysCount = remainDaysCount;
	}
	public String getCreateDateStr() {
		if (createDate != null){
			createDateStr=df.format(createDate);
		}
		return createDateStr;
	}	
	public String getEndDateStr() {
		if (endDate != null){
			endDateStr=df.format(endDate);
		}
		return endDateStr;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
}
