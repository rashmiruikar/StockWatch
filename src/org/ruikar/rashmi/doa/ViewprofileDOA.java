package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.model.RegisterBean;

public class ViewprofileDOA {

	public RegisterBean viewprofile(int userid)
	{
		RegisterBean rb = new RegisterBean();
		try
		{
		int userid1 = userid;
		String sql = "SELECT * from user where uid = " +userid1;
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("in profile DOA");
			rb.setFirstname(rs.getString("fname"));
			rb.setLastname(rs.getString("lname"));
			rb.setEmail(rs.getString("email"));
			rb.setUsername(rs.getString("uname"));
			rb.setPassword(rs.getString("password"));
			
		}
	}
		catch (SQLException e)
		{
			
		}

		return rb;
	}
}
