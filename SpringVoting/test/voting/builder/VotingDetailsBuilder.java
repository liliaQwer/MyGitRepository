package voting.builder;

import java.sql.Date;

import voting.model.VotingDetails;

public class VotingDetailsBuilder {
	int id;
	Date createDate;	
	
	public VotingDetailsBuilder withId(int id){
		this.id = id;
		return this;
	}
	
	public VotingDetailsBuilder withCreateDate(Date createDate){
		this.createDate = createDate;
		return this;
	}
	
	public VotingDetails build(){
		return new VotingDetails(id, createDate);
	}
}
