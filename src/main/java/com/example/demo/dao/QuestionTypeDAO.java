package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.QuestionTypeDTO;

@Repository
public class QuestionTypeDAO {

	@Qualifier("datasource1")
	@Autowired
	private DataSource dataSource;

	public List<QuestionTypeDTO> getQuestionTypeData() {
		Connection conn = DataSourceUtils.getConnection(dataSource);
		Handle handle = DBI.open(conn);
		UserSQLs userQLs = handle.attach(UserSQLs.class);
		return userQLs.getQuestionTypeData();
	}
	
	@RegisterMapper(UserMapper.class)
	interface UserSQLs {
		@SqlQuery("select * from QuestionType")
		List<QuestionTypeDTO> getQuestionTypeData();

	}
	
	public static class UserMapper implements ResultSetMapper<QuestionTypeDTO> {
		@Override
		public QuestionTypeDTO map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
			QuestionTypeDTO bean = new QuestionTypeDTO();
			bean.setQtype((r.getString("QTYPE")));		
			bean.setQid(r.getInt("QID"));
			return bean;
		}
	}

}
