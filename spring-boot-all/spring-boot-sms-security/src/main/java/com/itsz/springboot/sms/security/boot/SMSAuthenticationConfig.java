package com.itsz.springboot.sms.security.boot;

import com.itsz.springboot.sms.security.auth.SMSAuthenticationFilter;
import com.itsz.springboot.sms.security.auth.SMSAuthenticationProvider;
import com.itsz.springboot.sms.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SMSAuthenticationConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

     @Autowired
     private MyAuthenticationSuccessHandler authenticationSuccessHandler;

     @Autowired
     private UserService userService;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        SMSAuthenticationFilter smsAuthenticationFilter = new SMSAuthenticationFilter();
        smsAuthenticationFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        smsAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);

        SMSAuthenticationProvider smsAuthenticationProvider = new SMSAuthenticationProvider();
        smsAuthenticationProvider.setUserService(userService);

        builder.authenticationProvider(smsAuthenticationProvider)
                .addFilterAfter(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
