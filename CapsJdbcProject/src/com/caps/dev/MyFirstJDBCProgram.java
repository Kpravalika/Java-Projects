package com.caps.dev;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBCProgram {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			//1st Version
//			String dbUrl="jdbc:mysql://localhost:3306/caps28jan2019_db"
//					+ "?user=root&password=root";
//			con = DriverManager.getConnection(dbUrl); 
			
			//2nd Version
//			String dbUrl="jdbc:mysql://localhost:3306/caps28jan2019_db";
//			con = DriverManager.getConnection(dbUrl,"root","root");
			
			
			//3rd Version
			String dbUrl="jdbc:mysql://localhost:3306/CAPS28JAN2019_DB";
			
			FileReader in = new FileReader("C:\\Users\\Sunil\\Desktop\\SQL\\db.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			con = DriverManager.getConnection(dbUrl, prop);
			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from STUDENT_INFO";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			/*
			 * 4. Process the results
			 */

			while(rs.next()){
				int REGNO = rs.getInt("regno");
				String FNAME = rs.getString("fname");
				String LNAME = rs.getString("lname");
				String PASSWORD = rs.getString("password");
				String ISADMIN = rs.getString("isadmin");

				System.out.println(REGNO);
				System.out.println(FNAME);
				System.out.println(LNAME);
				System.out.println(PASSWORD);
				System.out.println(ISADMIN);
				System.out.println("*********************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally { 
			// 5. Close all the JDBC Objects
			if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
}





//void java.sql.DriverManager.registerDriver(Driver driver) throws SQLException


//Connection java.sql.DriverManager.getConnection(String url) throws SQLException

