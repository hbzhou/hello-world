
package com.itsz.springboot.sms.security.boot;

import com.itsz.springboot.sms.security.auth.SMSAuthenticationFilter;
import com.itsz.springboot.sms.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccssHandler;


    @Resource
    private DataSource dataSource;


    @Autowired
    private SMSAuthenticationConfig smsAuthenticationConfig;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionFixation().migrateSession();
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.csrf().disable()
                .formLogin()
                .successHandler(authenticationSuccssHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout();
    }


}
