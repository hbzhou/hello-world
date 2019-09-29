package com.itsz.springboot.sms.security.auth;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMSAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    public static final String SPRING_SECURITY_FORM_MOBLE_KEY = "mobile";
    public static final String SPRING_SECURITY_FORM_SMS_CODE_KEY = "smsCode";

    private String mobileParameter = SPRING_SECURITY_FORM_MOBLE_KEY;
    private String smsCodeParameter = SPRING_SECURITY_FORM_SMS_CODE_KEY;
    private boolean postOnly = true;

    // ~ Constructors
    // ===================================================================================================

    public SMSAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/sms", "POST"));
    }

    // ~ Methods
    // ========================================================================================================

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String mobile = obtainMobile(request);
        String smsCode = obtainSmsCode(request);

        if (mobile == null) {
            mobile = "";
        }

        if (smsCode == null) {
            smsCode = "";
        }

        mobile = mobile.trim();

        SMSAuthenticationToken authRequest = new SMSAuthenticationToken(
                mobile, smsCode);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected String obtainSmsCode(HttpServletRequest request) {
        return request.getParameter(smsCodeParameter);
    }

    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }

    protected void setDetails(HttpServletRequest request,
                              SMSAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }



}
