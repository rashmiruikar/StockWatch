package org.ruikar.rashmi.connection;

import java.sql.Connection;
import java.sql.DriverManager;


//public class dbconnection implements DbConnect {
public class dbconnection {
	public static final dbconnection a = new dbconnection();
	
	private dbconnection() {
		// TODO Auto-generated constructor stub
	}
	
	//@Override
	public Connection getconnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			ds.setServerName(System.getenv("ICSI518_SERVER"));
			ds.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
			ds.setDatabaseName(System.getenv("ICSI518_DB"));
			ds.setUser(System.getenv("ICSI518_USER"));
			ds.setPassword(System.getenv("ICSI518_PASSWORD"));
			con =ds.getConnection();
            //Class.forName("com.mysql.jdbc.Driver");
           // Connection con = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + portnumber + "/" + databasename, username, password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://" + ds.setServerName(System.getenv("ICSI518_SERVER")) + ":" + portnumber + "/" + databasename, username, password);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
		
	}
	public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        	System.err.println("Exception: " + ex.getMessage());
        }

}
}