package voting.model;

import java.util.ArrayList;
import java.util.List;

public class ActiveVotings {
	
	private int maxPage;
	private int currentPage;
	private List<Voting> votingList = new ArrayList<>();	
	
	public static class Voting{
		private int id;
		private String question;
		private int voteCount;
		private String owner;
		
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public int getVoteCount() {
			return voteCount;
		}
		public void setVoteCount(int voteCount) {
			this.voteCount = voteCount;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public List<Voting> getVotingList() {
		return votingList;
	}


	public void setVotingList(List<Voting> votingList) {
		this.votingList = votingList;
	}
}
