package com.lewis.security.brower.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewis.security.core.properties.LoginType;
import com.lewis.security.core.properties.LewisSecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/20.
 */
@Component
public class LewisAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(LewisAuthenticationFailureHandler.class);

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private LewisSecurityProperties lewisSecurityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登陆失败！");
        if (LoginType.JSON.equals(lewisSecurityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }

    }
}
