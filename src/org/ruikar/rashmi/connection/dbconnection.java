package org.ruikar.rashmi.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class dbconnection implements DbConnect {
	
	public static final dbconnection a = new dbconnection();
	private dbconnection() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Connection getconnection() {
		// TODO Auto-generated method stub
		try {
			
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + portnumber + "/" + databasename, username, password);
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