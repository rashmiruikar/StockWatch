package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.ruikar.rashmi.connection.dbconnection;

public class AccountDOA {

	public double getaccountbalance(int userid)
	{
		double bal=0.0;
		try
		{
			
		String sql = "SELECT balance from user where uid=" +userid;
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			
			bal= rs.getDouble("balance");
		
		}
		
	}
	catch (Exception e)
	{
		
	}

	
	return bal ;
	}
}

