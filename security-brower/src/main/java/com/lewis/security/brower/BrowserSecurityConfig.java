package com.lewis.security.brower;

import com.lewis.security.brower.authentication.LewisAuthenticationFailureHandler;
import com.lewis.security.brower.authentication.LewisAuthenticationSuccessHandler;
import com.lewis.security.core.properties.LewisSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/19.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private LewisSecurityProperties lewisSecurityProperties;

    @Resource
    private LewisAuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private LewisAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/sign-in.html","/authentication/require",
                        lewisSecurityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
