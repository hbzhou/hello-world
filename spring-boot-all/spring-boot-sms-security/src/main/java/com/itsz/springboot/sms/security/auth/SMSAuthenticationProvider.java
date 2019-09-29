package com.itsz.springboot.sms.security.auth;

import com.itsz.springboot.sms.security.auth.controller.AuthController;
import com.itsz.springboot.sms.security.auth.controller.SMSCode;
import com.itsz.springboot.sms.security.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.Assert;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;


public class SMSAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(SMSAuthenticationProvider.class);

    private UserService userService;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(SMSAuthenticationToken.class, authentication);

        String mobile = (authentication.getPrincipal() == null) ? "NONE_PROVIDED"
                : authentication.getName();

        UserDetails user = null;
        try {
            user = userService.loadUserByUsername(mobile);
        } catch (UsernameNotFoundException notFound) {
            logger.debug("User '" + mobile + "' not found");
            throw notFound;
        }

        Assert.notNull(user,
                "retrieveUser returned null - a violation of the interface contract");

        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException("Bad credentials");
        }

        String smsCode = authentication.getCredentials().toString();

        SMSCode sms = (SMSCode) sessionStrategy.getAttribute(new ServletWebRequest(null), AuthController.SESSION_KEY_SMS_CODE + mobile);

        if (sms == null) {
            logger.debug("Authentication failed: cache does not match stored value");
            throw new BadCredentialsException("can find match stored sms");
        }
        if (sms.getExpireTime().isBefore(LocalDateTime.now())){
            throw new BadCredentialsException("sms code expired");
        }

        if (!smsCode.equals(sms.getCode())){
            throw new BadCredentialsException("sms code does not match");
        }
        sessionStrategy.removeAttribute(new ServletWebRequest(null) , AuthController.SESSION_KEY_SMS_CODE + mobile);

        return createSuccessAuthentication(mobile, authentication, user);
    }

    protected Authentication createSuccessAuthentication(Object principal,
                                                         Authentication authentication, UserDetails user) {
        SMSAuthenticationToken result = new SMSAuthenticationToken(
                principal, authentication.getCredentials(),
                user.getAuthorities());
        result.setDetails(authentication.getDetails());

        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SMSAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
