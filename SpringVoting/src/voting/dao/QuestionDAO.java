package voting.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import voting.model.ActiveVotings;
import voting.model.VotingDetails;

@Component
public class QuestionDAO {
	
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	
	public int getActiveVotingCount(){
		return jdbcTemplate.queryForInt("SELECT count(*)  FROM mydb.questions where is_blocked=false and (end_date is null or end_date > curdate());");
	}
	
	public List<ActiveVotings.Voting> getActiveVoting(){
		List<ActiveVotings.Voting> list = jdbcTemplate.query("SELECT * FROM mydb.questions where is_blocked=false and (end_date is null or end_date > curdate())", new ParameterizedRowMapper<ActiveVotings.Voting>() {

			@Override
			public ActiveVotings.Voting mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				ActiveVotings.Voting voting = new ActiveVotings.Voting();				
				voting.setId(arg0.getInt("id"));
				voting.setOwner(arg0.getString("owner"));
				voting.setQuestion(arg0.getString("question"));
				voting.setVoteCount(getVotesCount(arg0.getInt("id")));		
				return voting;
			}
		});		
		return list;
	}

	
	private int getVotesCount(int questionId){
		return jdbcTemplate.queryForInt("SELECT count(*)  FROM mydb.answers where question_id = ?", questionId);
	}
	
	public VotingDetails getDetailsById(int id){
		VotingDetails details = new VotingDetails();
		details.setId(id);
		Map<String, Object> dataMap = jdbcTemplate.queryForMap("select * from mydb.questions where id = ?", id);
		details.setCreateDate((Date)dataMap.get("create_date"));
		details.setEndDate((Date)dataMap.get("end_date"));
		details.setQuestion((String)dataMap.get("question"));	
		return details;
	}
}
