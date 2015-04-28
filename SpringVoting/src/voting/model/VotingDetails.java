package voting.model;

import java.util.ArrayList;

import voting.util.User;

public class VotingDetails {
	
	int id=1;
	String createDate="01.01.2010";
	String endDate="01.02.2010";
	int votesCount=5;
	String question="Надо ли путешествовать?";
	ArrayList<String> commentsList;
	ArrayList<User> votersList;
	VotingResult votingResult=new VotingResult();
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
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
}
