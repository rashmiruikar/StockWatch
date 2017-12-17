package org.ruikar.rashmi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.controller.AdminController;
import org.ruikar.rashmi.doa.AdminDOA;

@ManagedBean(name="AdminBean")
@SessionScoped
public class AdminBean {
	
	private String approval;
	
	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = "Yes";
	}

	List<RegisterBean> list;
		
	public List<RegisterBean> getList() {
		return list;
	}

	public void setList(List<RegisterBean> list) {
		this.list = list;
	}
	List<RegisterBean> list1 = new ArrayList<RegisterBean>();
	AdminController ac = new AdminController();

	@SuppressWarnings("unchecked")
	public AdminBean()
	{
		list1 = ac.getInfo();
		this.list = list1;
		System.out.println(list);
		
	}
	public void getInfo()
	{
		
		/*List<LoginBean> list1 = new ArrayList<LoginBean>();
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
			list = list1;*/
			
			//AdminDOA ad = new AdminDOA();
			/*List<RegisterBean> list1 = new ArrayList<RegisterBean>();
			AdminController ac = new AdminController();
			list1 = ac.getInfo();
			this.list = list;
			System.out.println(list);
			for(int i = 0; i<list.size();i++)
			{
				System.out.println(list.get(i).getFirstname());
				
			}
			
		}*/
		/*catch(Exception e)
		{
			
		}
		*/
	}
	
	public String approve(int uid) throws SQLException
	{
		System.out.println("id:"+uid);
		try
		{
				  		
		String sql = "UPDATE user SET approval = ? where uid = ?";
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
		ps.setString(1,"Yes");
		ps.setInt(2,uid);
		ps.executeUpdate();
		ps.close();
		
		}
		catch (SQLException e)
		{
			throw e;
		}
		
		return "adminpage";
	}
	
	public String decline(int uid) throws SQLException
	{
		System.out.println("id:"+uid);
		try
		{
				  		
		String sql = "UPDATE user SET approval = ? where uid = ?";
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
		ps.setString(1,"No");
		ps.setInt(2,uid);
		ps.executeUpdate();
		ps.close();
		
		}
		catch (SQLException e)
		{
			throw e;
		}
		
		return "adminpage";
	}

}
