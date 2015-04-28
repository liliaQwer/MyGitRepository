package voting.model;

public class VotingResult {
	int yesCount=2;
	int noCount=3;
	int abstainCount=0;
	
	public VotingResult() {
		
	}
	
	public VotingResult(int yesCount, int noCount, int abstainCount) {
		this.yesCount=yesCount;
		this.noCount=noCount;
		this.abstainCount=abstainCount;
	}
	
	public int getYesCount() {
		return yesCount;
	}
	public void setYesCount(int yesCount) {
		this.yesCount = yesCount;
	}
	public int getNoCount() {
		return noCount;
	}
	public void setNoCount(int noCount) {
		this.noCount = noCount;
	}
	public int getAbstainCount() {
		return abstainCount;
	}
	public void setAbstainCount(int abstainCount) {
		this.abstainCount = abstainCount;
	}

}
