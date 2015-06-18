package voting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import voting.model.VotingDetails.VotingResult;

@Component
public class AnswerDAO {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	
	public List<VotingResult> getResultsByQuestionId(int questionId){
		List<VotingResult> list = jdbcTemplate.query("select id, answer from mydb.answers where question_id = ?", new ParameterizedRowMapper<VotingResult>() {

			@Override
			public VotingResult mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				VotingResult voteResult = new VotingResult();
				voteResult.setAnswer(arg0.getString("answer"));
				voteResult.setId(arg0.getInt("id"));
				voteResult.setVotersList(jdbcTemplate.query("select login from mydb.voting where answer_id = ?", new ParameterizedRowMapper<String>() {

					@Override
					public String mapRow(ResultSet arg0, int arg1)
							throws SQLException {						
						return arg0.getString("login");
					}
				}, arg0.getInt("id")));				
				return voteResult;
			}
		}, questionId);
		
		return list;
	}

}
