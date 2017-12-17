package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.model.RegisterBean;

public class UpdateprofileDOA {

	public RegisterBean update(RegisterBean rb)
	{
		try
		{
			System.out.println("Userid:" +rb.getUid());
			int userid = rb.getUid();
			String sql = "UPDATE user SET fname = ?, lname = ?, email = ?, uname = ?, password = ? where uid ="+userid;
			PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
			
			ps.setString(1, rb.getFirstname());
			ps.setString(2, rb.getLastname());
			ps.setString(3, rb.getEmail());
			ps.setString(4, rb.getUsername());
			ps.setString(5, rb.getPassword());
			ps.executeUpdate();
			ps.close();
									
		}
		
		catch(SQLException e)
		{
			
		}
		return rb;
	}
}
