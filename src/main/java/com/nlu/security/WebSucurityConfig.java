package com.nlu.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nlu.security.jwt.AuthEntryPointJwt;
import com.nlu.security.jwt.AuthTokenFilter;
import com.nlu.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSucurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unAuthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web
//	        .ignoring()
//	        .antMatchers("/resources/**")
//	        .antMatchers("/publics/**");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unAuthorizedHandler).and()
	     .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
        .antMatchers("/admin/**").permitAll()
        .antMatchers("/product/**").permitAll()
        .antMatchers("/publics/**").permitAll()
        .antMatchers("/auth/**").permitAll()
        .anyRequest().authenticated()
        
        ;
		//hasRole("ADMIN")
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	public class CustomAccessDeniedHandler implements AccessDeniedHandler {

//	    public static final Logger LOG
//	      = Logger.getLogger(CustomAccessDeniedHandler.class);

	    @Override
	    public void handle(
	      HttpServletRequest request,
	      HttpServletResponse response, 
	      AccessDeniedException exc) throws IOException, ServletException {
	        
	        Authentication auth 
	          = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	        	System.out.println("a");
//	            LOG.warn("User: " + auth.getName() 
//	              + " attempted to access the protected URL: "
//	              + request.getRequestURI());
	        }

//	        response.sendRedirect(request.getContextPath() + "/accessDenied");
	    }
	}
}
