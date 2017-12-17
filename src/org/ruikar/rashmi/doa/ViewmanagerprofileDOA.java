package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.model.RegisterBean;

public class ViewmanagerprofileDOA {

	public List getmgrinfo()
	{
	List<RegisterBean> list1 = new ArrayList<RegisterBean>();
	
	try
	{
		String sql = "SELECT fname, lname, uid from user where role = 'Manager' and approval IS NOT NULL";
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			RegisterBean rb = new RegisterBean();
			rb.setFirstname(rs.getString("fname"));
			rb.setLastname(rs.getString("lname"));
			rb.setUid(rs.getInt("uid"));
			list1.add(rb);
							
		}
	}
	catch (Exception e)
	{
		
	}

	return list1;
}
	
	public List getmymgrinfo(int userid)
	{
	List<RegisterBean> list1 = new ArrayList<RegisterBean>();
	
	try
	{
		int mid = 0;
		String sql1= "SELECT mid from user_manager where uid ="+userid;
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql1);
		ResultSet rs1 = ps.executeQuery();
		while(rs1.next())
		{
			 mid = rs1.getInt("mid");
		}
		
		
		String sql = "SELECT fname, lname from user where uid =" +mid;
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			RegisterBean rb = new RegisterBean();
			rb.setFirstname(rs.getString("fname"));
			rb.setLastname(rs.getString("lname"));
			
			list1.add(rb);
							
		}
	}
	catch (Exception e)
	{
		
	}

	return list1;
}
}
