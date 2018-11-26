package com.spotigram.models;

import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name="users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sg_user_id")
    private int userID; 
	
    private String username;
    
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="u_password")
    private String password;
	@Column(name="user_first_name")
    private String firstName;
	@Column(name="user_last_name")
    private String lastName;
	@Column(name="user_email")
    private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private boolean isbanned;
    
    @ManyToOne
    @JoinColumn(name="user_role")
    private RolesModel roles;
    
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int userID, String username, String password, String firstName, String lastName, String email,
			boolean isbanned, RolesModel roles) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isbanned = isbanned;
		this.roles = roles;
	}

	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsbanned() {
		return isbanned;
	}

	public void setIsbanned(boolean isbanned) {
		this.isbanned = isbanned;
	}

	public String getRoles() {
		return roles.getRole_name();
	}

	public void setRoles(RolesModel roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isbanned ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isbanned != other.isbanned)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", isbanned=" + isbanned + ", roles="
				+ roles + "]";
	}
    
    
	
    
}
