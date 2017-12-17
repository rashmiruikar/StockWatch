package org.ruikar.rashmi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.connection.dbconnection;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String session;
	private String role;
	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String login() throws SQLException {
		try {
			//System.out.println(this.role);
			String sql = "SELECT fname, role, uname, password from user where uname = ? and password = ?";
			PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
			st.setString(1, this.username);
			st.setString(2, this.password);

			// Execute the statement
			ResultSet rs = st.executeQuery();

			// Iterate through results
			if (rs.next()) {
				session = rs.getString("uname") + " is successfully logged in";
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", session);

				System.out.println("Name is: " + rs.getString("fname"));
				this.setFirstname(rs.getString("fname"));
				this.setRole(rs.getString("role"));
				System.out.println(rs.getString("role"));
				System.out.println(this.role);
				if (this.role.equals("User"))
				{
						return "homepage";
				}
				else if(this.role.equals("Manager"))
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
	System.out.println("profile changes");
}
}