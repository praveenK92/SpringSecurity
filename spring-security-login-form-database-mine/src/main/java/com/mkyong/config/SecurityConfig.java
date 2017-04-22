package com.mkyong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mkyong.service.UserDetailService;
import com.mkyong.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Autowired
	DataSource d1;*/
	@Autowired
	private UserService userService;
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	/*@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(new UserDetailService(userService)).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*http.authorizeRequests()
			.antMatchers("/dba/**").access("hasRole('ROLE_DBA')")
			.antMatchers("/welcome/**").access("hasRole('ROLE_USER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/login").failureUrl("/login?error")
					.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.csrf();*/
		http.authorizeRequests()
		.antMatchers("/dba/**").access("hasRole('ROLE_DBA')")
		.antMatchers("/welcome/**").authenticated()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
			.formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
		.and()
			.logout().logoutSuccessUrl("/login?logout")
		.and()
			.exceptionHandling().accessDeniedPage("/403")
		.and()
			.csrf();
		
	}
}