package org.ruikar.rashmi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.doa.UpdateprofileDOA;
import org.ruikar.rashmi.doa.ViewprofileDOA;

@ManagedBean(name="RegisterBean")
@SessionScoped
public class RegisterBean {

	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String role;
	private DecimalFormat balance;
	private Boolean checkmanager;
	private String approval;
	private String session;
	private int uid;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public Boolean getCheckmanager() {
		return checkmanager;
	}
	public void setCheckmanager(Boolean checkmanager) {
		if(checkmanager)
		{
		this.role = "Manager";
		}
		else
		this.role = "User";
		this.checkmanager = checkmanager;
		
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public DecimalFormat getBalance() {
		return balance;
	}
	public void setBalance(DecimalFormat balance) {
		this.balance = balance;
	}
	
	public String register() throws SQLException{
		
		try
		{
			System.out.println("We are in register......");
		String sql = "SELECT fname, lname from user where uname =?";
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		st.setString(1, this.username);
		ResultSet rs = st.executeQuery();
		System.out.println("value of resultset "+ rs);
		if(rs.next())
		{
			System.out.println("Result set is not empty");
			this.firstname = rs.getString("fname");
			this.lastname = rs.getString("lname");
			System.out.println(rs.getString("fname")+" "+rs.getString("lname")+" already exists");
			this.firstname = "";
			this.lastname = "";
			this.email = "";
			this.username = "";
			this.password = "";
			return "register";
		}
		else
		{
			System.out.println("It is inserting value");
			System.out.println("Role1:"+this.role);
			System.out.println("bool:"+this.checkmanager);
			String sql1 = "INSERT into stockdb.user(fname,lname,uname,password,email,role,balance,approval) values(?,?,?,?,?,?,?,?)";
			PreparedStatement st1 = dbconnection.a.getconnection().prepareStatement(sql1);
			st1.setString(1,this.firstname);
			System.out.println("Firstname:"+this.firstname);
			st1.setString(2,this.lastname);
			st1.setString(3,this.username);
			st1.setString(4,this.password);
			st1.setString(5,this.email);
			st1.setString(6,this.role);
			System.out.println("Role:"+this.role);
			st1.setFloat(7,100000);	
			st1.setString(8, this.approval);
			st1.executeUpdate();
			st1.close();
			
		}
	}
		catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} 
		finally {
			try {
				dbconnection.a.getconnection().close();
			} catch (SQLException e) 
			{
			}
		}
		return "login";
		
	}
	
	public String login() throws SQLException {
		try {
			//System.out.println(this.role);
			int session1;
			String sql = "SELECT * from user where uname = ? and password = ?";
			PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
			st.setString(1, this.username);
			st.setString(2, this.password);

			// Execute the statement
			ResultSet rs = st.executeQuery();

			// Iterate through results
			if (rs.next()) {
				session1 = rs.getInt("uid");
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session1", session1);

				System.out.println("Name is: " + rs.getString("fname"));
				this.setFirstname(rs.getString("fname"));
				this.setRole(rs.getString("role"));
				this.setApproval(rs.getString("approval"));
				System.out.println(this.approval);
				
				System.out.println(this.role);
				if (this.role.equals("User"))
				{
						return "homepage";
				}
				else if(this.role.equals("Manager") && this.approval.equals("Yes"))
				{
					return "managerhomepage";
				}
				else if(this.role.equals("Admin"))
				{
					return "adminpage";
				}
				else
				{
					return "login";
				}
			} 
			else 
			{
				this.username = "";
				System.out.println("invalid user");
				
				  FacesContext obj = FacesContext.getCurrentInstance();
				  FacesMessage message= new FacesMessage("Invalid credentials. Please try again");
				  obj.addMessage("myform:username", message);
				 
				return "login";
				
			}
		}

		catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} 
		finally {
			try
			{
				System.out.println("Before connection");
				dbconnection.a.getconnection().close();
				System.out.println("After connection");
				
			}
			catch (SQLException e)
			{
				
			}

		}

		return "login";
	}
	
public String logout() {
		
		//String sname =(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session");
		//System.out.println("before" + abc);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//System.out.println("after"+ (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session")); 
		return "login";

	}

public void updateprofile()
{
	
		int userid = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session1");
		RegisterBean rb = new RegisterBean();
		rb.setFirstname(this.firstname);
		rb.setLastname(this.lastname);
		rb.setEmail(this.email);
		rb.setUsername(this.username);
		rb.setPassword(this.password);	
		rb.setUid(userid);
		UpdateprofileDOA up = new UpdateprofileDOA();
		up.update(rb);
		System.out.println("update successful");
					
}

public String viewprofile()
{
	int userid = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session1");
	//RegisterBean rb = new RegisterBean();
	
	ViewprofileDOA vp = new ViewprofileDOA();
	RegisterBean rb = vp.viewprofile(userid);
	this.firstname = rb.getFirstname();
	this.lastname = rb.getLastname();
	this.email = rb.getEmail();
	this.username = rb.getUsername();
	this.password = rb.getPassword();
	System.out.println(this.firstname + "view profile");
	return "profile";
	
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
