package com.zuul.service.zuul.resource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
@Configuration
public class ResourceServiceConfig  extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.resourceId("resource_server").tokenStore(getTokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("oauth-service/oauth/token").permitAll().anyRequest().authenticated();
	}
	
	@Bean
	public TokenStore getTokenStore() {
		return new JdbcTokenStore(dataSource);
	}
}
