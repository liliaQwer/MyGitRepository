package dbAttempt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class MyDAO {

	SimpleJdbcTemplate template;

	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}
	
	public void addFile(FileInfo fileInfo){
		String query="insert into sprav1:c_file_210 values(null,?,null,null,null,?,null,null,null,null,null,null,null,null,null,null,'programm')";
		template.update(query, fileInfo.getMessageNum(),fileInfo.getServiceId());
	}
	
	public void addFileWithNamedParams(FileInfo fileInfo){
		String query="insert into sprav1:c_file_210 values(null,:messageNum,null,null,null,:serviceId,null,null,null,null,null,null,null,null,null,null,'programm')";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("messageNum", fileInfo.getMessageNum());
		map.put("serviceId", fileInfo.getServiceId());
		template.update(query, map);
		
	}
	
	public FileInfo getFileInfoByServId(int serviceId){
		String query="select * from sprav1:c_file_210 where service_id=?";
		return template.queryForObject(query, new ParameterizedRowMapper<FileInfo>() {

			@Override
			public FileInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
				FileInfo f=new FileInfo();
				f.setMessageNum(arg0.getInt("msg_num"));
				f.setServiceId(arg0.getInt("service_id"));
				return f;
			}
		}, serviceId);
	}
}
