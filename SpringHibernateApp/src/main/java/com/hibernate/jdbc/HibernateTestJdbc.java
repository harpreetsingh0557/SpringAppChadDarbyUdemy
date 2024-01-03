package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.MysqlConnection;
import com.zaxxer.hikari.HikariDataSource;

public class HibernateTestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// com.mysql.cj.jdbc.MysqlDataSource mySqlDataSource = new com.mysql.cj.jdbc.MysqlDataSource();
		
		/** Use connection pool library to use JDBC Data Source as
		 *  recommended by Oracle
		 *  https://docs.oracle.com/javase/tutorial/jdbc/basics/sqldatasources.html
		 *  Also someone in the Stackoverflow recommended to use
		 *  Connection Pool library (like HikariCP) for JDBC connection pooling
		 */
		
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/world");
		hikariDataSource.setUsername("root");
		hikariDataSource.setPassword("M_rackyun1");
		
		try {
			Connection mySqlConnection = hikariDataSource.getConnection();
			
			String query = "select * from COUNTRY where code = 'ARG'";
			
			Statement statement = mySqlConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			//Know why the following statement is written:
//			if(resultSet.next()){
			String countryCode = resultSet.getString("Code");
			
			String countryName = resultSet.getString("Name");
			
			System.out.println("Output of the Query result is: " + 
			"Country Code: " + countryCode + " " + "Country Name: " + countryName);
//			}
		}	
		catch ( SQLException sqlException ) {
			System.out.println("Sql error:" + sqlException.getMessage());
		}
		
		
		
		
	}

}
