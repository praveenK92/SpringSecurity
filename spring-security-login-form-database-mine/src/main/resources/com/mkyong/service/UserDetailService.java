package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mkyong.models.UserModel;
import com.mkyong.models.UserRolesModel;

public class UserDetailService implements UserDetailsService{
	
	private UserService userService;
	public UserDetailService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		UserModel userModel=userService.getUserModel(userName);
		if(userModel!=null){
			List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
			for(UserRolesModel userRolesModel:userModel.getUserRoleModelList()){
				GrantedAuthority g1=new SimpleGrantedAuthority(userRolesModel.getRole());
				grantedAuthorities.add(g1);
			}
			return new User(userModel.getUsername(),userModel.getPassword(),
					grantedAuthorities);
		}
		else throw new UsernameNotFoundException("User "+userName+" Not Found!");
	}
}
