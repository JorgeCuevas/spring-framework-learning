package com.georgesoft.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.georgesoft.model.Circle;

@Component
public class JdbcDaoImpl {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	/* public Circle getCircle(int idCircle) {
		Connection conn = null;
		Circle circle = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, idCircle);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				circle = new Circle(idCircle, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			System.out.println("error getting circle " + ex.getMessage());
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("error closing conn " + ex.getMessage());
			}

		}

		return circle;
	}
*/
	
	public int getCountCircle(){
		String sql = "select count(*) from circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "SELECT name FROM circle where id = ?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId} ,String.class);
	}
	

	public Circle getCircleById(int circleId){
		String sql = "SELECT name FROM circle where id = ?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId}, new CircleMapper());
	}

	public List<Circle> getAllCircles(){
		String sql = "SELECT * FROM circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
//
//	public void insertCircle(Circle circle){
//		String sql = "INSERT INTO circle (id, name) values (?, ?)";
//		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
//	}


	public void insertCircle(Circle circle){
		String sql = "INSERT INTO circle (id, name) values (:id, :name)";
		SqlParameterSource namedParameter = new MapSqlParameterSource("id", circle.getId())
															.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameter);
	}

	public void createTriaguleTable(){
		String sql ="CREATE TABLE triangule (ID INTEGER, NAME CHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	
	// this is a mapper class to circle
	private static final class CircleMapper implements RowMapper<Circle>{
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
//			circle.setId(rs.getInt("ID"));
			circle.setName(rs.getString("NAME"));
			return circle;
		}
		
	}
}
