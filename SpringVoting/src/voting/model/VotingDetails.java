package voting.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import voting.util.Roles;


public class VotingDetails {
	
	int id;
	Date createDate;
	Date endDate;
	String createDateStr;
	String endDateStr;
	boolean enabled;
	int remainDaysCount;
	int votesCount;
	String question;
	List<VotingResult> votingResult;
	SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		
	public int getVotesCount() {
		int count = 0;
		for(VotingResult result: votingResult){
			count += result.getVotesCount();
		}
		return count;
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
	public List<VotingResult> getVotingResult() {
		return votingResult;
	}
	public void setVotingResult(List<VotingResult> votingResult) {
		
		this.votingResult = votingResult;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	
	public static class VotingResult{
		int id;
		String answer;
		int votesCount;
		List<String> votersList;
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public int getVotesCount() {			
			return votersList.size();
		}
		public void setVotesCount(int votesCount) {
			this.votesCount = votesCount;
		}
		public List<String> getVotersList() {
			return votersList;
		}
		public void setVotersList(List<String> votersList) {
			this.votersList = votersList;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}

	public boolean isUserVoted(String userName) {
		if (userName == null || userName.equals(Roles.ANONYMOUS)){
			return false;
		}
		for (VotingResult result: votingResult){
			for (String login: result.votersList){
				if (userName.equals(login)){
					return true;
				}
			}
		}
		return false;
	}
	
}
