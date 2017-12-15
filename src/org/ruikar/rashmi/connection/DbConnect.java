package org.ruikar.rashmi.connection;

import java.sql.Connection;

public interface DbConnect {
	
		public String hostname = "localhost";
		public String portnumber = "3306";
		public String databasename = "stockdb";
		public String username = "root";
		public String password = "root";
		public Connection getconnection();
		
	}

