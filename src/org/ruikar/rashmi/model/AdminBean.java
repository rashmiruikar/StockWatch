package org.ruikar.rashmi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.connection.dbconnection;

@ManagedBean(name="AdminBean")
public class AdminBean {
	
	private String approval;
	
	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = "Yes";
	}

	List<LoginBean> list;
		
	public List<LoginBean> getList() {
		return list;
	}

	public void setList(List<LoginBean> list) {
		this.list = list;
	}

	public void getInfo()
	{
		System.out.println("Abhi is ....");
		List<LoginBean> list1 = new ArrayList<LoginBean>();
		try
		{
			
			String sql = "SELECT fname, lname, uid from user where role = 'Manager'";
			PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				LoginBean lb = new LoginBean();
				lb.setFirstname(rs.getString("fname"));
				lb.setLastname(rs.getString("lname"));
				lb.setUid(rs.getInt("uid"));
				list1.add(lb);
								
			}
			list = list1;
			
			for(int i = 0; i<list.size();i++)
			{
				System.out.println(list.get(i).getFirstname());
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public String approve(String uid) throws SQLException
	{
		System.out.println("id:"+uid);
		return "stockview";
		/*try
		{
		FacesContext context;
		ExternalContext externalContext = context.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		  uid = params.get("apr");
		  		
		String sql = "UPDATE user SET approval = ? where uid = ?";
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
		ps.setString(1,this.approval);
		ps.setInt(2,uid);
		ps.executeUpdate();
		ps.close();
		return null;
		}
		catch (SQLException e)
		{
			throw e;
		}*/
	}

}
