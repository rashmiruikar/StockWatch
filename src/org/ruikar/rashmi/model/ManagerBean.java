package org.ruikar.rashmi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.controller.AdminController;
import org.ruikar.rashmi.controller.ManagerprofileController;

@ManagedBean(name="ManagerBean")
@SessionScoped
public class ManagerBean {
	private String firstname;
	private String lastname;
	private int uid;
	private String approval;
	private String role;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	List<RegisterBean> list;
	
	public List<RegisterBean> getList() {
		return list;
	}

	public void setList(List<RegisterBean> list) {
		this.list = list;
	}
	
	List<RegisterBean> list1 = new ArrayList<RegisterBean>();
	ManagerprofileController mpc = new ManagerprofileController();
	
	public ManagerBean()
	{
		list1 = mpc.getInfo();
		this.list = list1;
		System.out.println(list);
	}
	
	public String viewmanagerprofile()
	{
		System.out.println("in view mgr profile");
		
		return "viewmgrprofile";
	}
	
	public String viewmymanager()
	{
		int userid = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session1");
		System.out.println("my mgr");
		list1 = mpc.getmymgrInfo(userid);
		this.list = list1;
		return "viewmymgr";
	}
	
	public String selectmanager(int mid)
	{
		System.out.println("id:"+mid);
		try
		{
		int user = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session1");  		
		//String sql = "UPDATE user_manager SET mid ="+mid + " where uid =" +user;
		String sql = "INSERT into user_manager(uid,mid) values(?,?)";
		PreparedStatement ps = dbconnection.a.getconnection().prepareStatement(sql);
		ps.setInt(1,user);
		ps.setInt(2,mid);
		ps.executeUpdate();
		ps.close();
		
		}
		catch (SQLException e)
		{
		
		}
		
		return "viewmgrprofile";
	}
}
