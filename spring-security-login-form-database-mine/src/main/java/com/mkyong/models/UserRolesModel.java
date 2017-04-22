package com.mkyong.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="user_roles")
public class UserRolesModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_role_id")
	private int userRoleID;
	@Column(name="username",nullable=false)
	private String userName;
	@Column(name="role",nullable=false)
	private String role;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userName",referencedColumnName="username",
		updatable=false,insertable=false)
	@Expose(serialize=false)
	private UserModel userModel;
	
	public UserRolesModel(){}	
	public UserRolesModel(int userRoleID, String userName, String role){
		this.userRoleID = userRoleID;
		this.userName = userName;
		this.role = role;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
