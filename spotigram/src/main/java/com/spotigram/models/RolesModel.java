package com.spotigram.models;

public class RolesModel {
    private int sg_role_id;
    private String role_name;
    
    
	public RolesModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RolesModel(int sg_role_id, String role_name) {
		super();
		this.sg_role_id = sg_role_id;
		this.role_name = role_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result + sg_role_id;
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
		RolesModel other = (RolesModel) obj;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		if (sg_role_id != other.sg_role_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RolesModel [sg_role_id=" + sg_role_id + ", role_name=" + role_name + "]";
	}
	public int getSg_role_id() {
		return sg_role_id;
	}
	public void setSg_role_id(int sg_role_id) {
		this.sg_role_id = sg_role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
    
    
}
