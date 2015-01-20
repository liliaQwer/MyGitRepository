package dbAttempt;

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
}
