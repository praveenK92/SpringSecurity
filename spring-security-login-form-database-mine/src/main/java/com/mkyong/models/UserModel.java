package com.mkyong.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="users")
public class UserModel {
	@Id
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(name="enabled",nullable=false)
	private boolean enabled;
	@Column(name="accountNonExpired",nullable=false)
	private boolean accountNotExpired;
	@Column(name="accountNonLocked",nullable=false)
	private boolean accountNonLocked;
	@Column(name="credentialsNonExpired",nullable=false)
	private boolean credentialsNonExpired;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="userModel",cascade=CascadeType.ALL,orphanRemoval=true)
	@Fetch(FetchMode.SELECT)
	private List<UserRolesModel> userRoleModelList;
	
	public UserModel(){
	}
	
	public UserModel(String username, String password, boolean enabled, boolean accountNotExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, List<UserRolesModel> userRoleModelList) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNotExpired = accountNotExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.userRoleModelList = userRoleModelList;
	}
	public List<UserRolesModel> getUserRoleModelList() {
		return userRoleModelList;
	}
	public void setUserRoleModelList(List<UserRolesModel> userRoleModelList) {
		this.userRoleModelList = userRoleModelList;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNotExpired() {
		return accountNotExpired;
	}
	public void setAccountNotExpired(boolean accountNotExpired) {
		this.accountNotExpired = accountNotExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
}
