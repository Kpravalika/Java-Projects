package com.caps.dev;

 import java.io.FileReader;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.Properties;
 import java.util.Scanner;

 public class  DeleteProfile  {
 	public static void main(String[] args) {
 		Connection con = null;
 		PreparedStatement pstmt = null;
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
// 			String dbUrl="jdbc:mysql://localhost:3306/caps28jan2019_db"
// 					+ "?user=root&password=root";
// 			con = DriverManager.getConnection(dbUrl); 
 			
 			//2nd Version
// 			String dbUrl="jdbc:mysql://localhost:3306/caps28jan2019_db";
// 			con = DriverManager.getConnection(dbUrl,"root","root");
 			
 			
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
 			/*String sql = "insert into STUDENT_INFO values(?,?,?,?,?)";

 			pstmt = con.prepareStatement(sql);
 			
 			System.out.println("Enter a Regno: ");
 			Scanner input = new Scanner(System.in);
 			int REGNO = Integer.parseInt(input.nextLine());
 			pstmt.setInt(1, REGNO);
 			
 			System.out.println("Enter the first name: ");
 			String FNAME =input.nextLine();
 			pstmt.setString(2, FNAME);
 			
 			System.out.println("Enter the lastt name: ");
 			String LNAME =input.nextLine();
 			pstmt.setString(3, LNAME);
 			
 			System.out.println("Enter password: ");
 			String PASSWORD =input.nextLine();
 			pstmt.setString(4, PASSWORD);
 			
 			System.out.println("Is Admin: ");
 			String ISADMIN =input.nextLine();
 			pstmt.setString(5, ISADMIN);
 			
 			int count=pstmt.executeUpdate();
 			if(count>0)
 			{
 				System.out.println("profile created");
 			}
 			else
 			{
 				System.out.println("profile created");
 			}*/
 			
 			String sql1 = "delete regno from STUDENT_INFO where regno=?";
 			pstmt = con.prepareStatement(sql1);
 			
 			System.out.println("Enter a Regno: ");
 			Scanner input1 = new Scanner(System.in);
 			int REGNO = Integer.parseInt(input1.nextLine());
 			pstmt.setInt(1, REGNO);

 			/*
 			 * 4. Process the results
 			 */

 				System.out.println(REGNO);
 				
 				System.out.println("*********************");
 			

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
 			if(pstmt != null) {
 				try {
 					pstmt.close();
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 			if(con != null) {
 				try {
 					con.close();
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			} 
 		}
 	}
 }





 //void java.sql.DriverManager.registerDriver(Driver driver) throws SQLException


 //Connection java.sql.DriverManager.getConnection(String url) throws SQLException


