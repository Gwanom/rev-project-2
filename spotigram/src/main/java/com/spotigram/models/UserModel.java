package com.spotigram.models;

public class UserModel {
    private int sg_user_id; 
    private String username;
    private String u_password;
    private String user_first_name;
    private String user_last_name;
    private String user_email;
    private int user_role;
    private boolean isBanned;
    
    
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserModel(int sg_user_id, String username, String u_password, String user_first_name, String user_last_name,
			String user_email, int user_role, boolean isBanned) {
		super();
		this.sg_user_id = sg_user_id;
		this.username = username;
		this.u_password = u_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role = user_role;
		this.isBanned = isBanned;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isBanned ? 1231 : 1237);
		result = prime * result + sg_user_id;
		result = prime * result + ((u_password == null) ? 0 : u_password.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		result = prime * result + user_role;
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
		if (isBanned != other.isBanned)
			return false;
		if (sg_user_id != other.sg_user_id)
			return false;
		if (u_password == null) {
			if (other.u_password != null)
				return false;
		} else if (!u_password.equals(other.u_password))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		if (user_role != other.user_role)
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
		return "UserModel [sg_user_id=" + sg_user_id + ", username=" + username + ", u_password=" + u_password
				+ ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name + ", user_email="
				+ user_email + ", user_role=" + user_role + ", isBanned=" + isBanned + "]";
	}

    
    
}
