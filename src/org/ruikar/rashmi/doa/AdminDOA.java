package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.model.LoginBean;
import org.ruikar.rashmi.model.RegisterBean;

public class AdminDOA {
	
	public List getinfo()
	{
	List<RegisterBean> list1 = new ArrayList<RegisterBean>();
	
	try
	{
		String sql = "SELECT fname, lname, uid from user where role = 'Manager' and approval IS NULL";
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
}
