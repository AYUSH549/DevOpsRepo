package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.QuestionListDTO;


@Repository
public class QuestionListDAO {
	
	@Qualifier("datasource1")
	@Autowired
	private DataSource dataSource;
	
	public List<QuestionListDTO> getAllData(int qid) {
		Connection conn = DataSourceUtils.getConnection(dataSource);
		Handle handle = DBI.open(conn);
		UserSQLs userQLs = handle.attach(UserSQLs.class);
		return userQLs.getAllData(qid);
	}
	
	@RegisterMapper(UserMapper.class)
	interface UserSQLs {
		@SqlQuery("select * from QuestionsData where QID=:qid")
		List<QuestionListDTO> getAllData(@Bind("qid") int qid);

	}
	
	
	public static class UserMapper implements ResultSetMapper<QuestionListDTO> {
		@Override
		public QuestionListDTO map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
			QuestionListDTO bean = new QuestionListDTO();
			bean.setQid(r.getInt("QID"));		
			bean.setQuestions(r.getString("Questions"));
			bean.setOptions(r.getString("Options"));
			bean.setQuestionsUrl(r.getString("QuestionsUrl"));
			bean.setAnswers(r.getString("Answer"));
			bean.setDetailedAnswers(r.getString("DetailedAnswer"));
			bean.setAnswerUrls(r.getString("AnswerUrl"));
			return bean;
		}
	}


}
