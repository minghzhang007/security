package com.lewis.security.brower.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewis.security.core.properties.LoginType;
import com.lewis.security.core.properties.LewisSecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
public class LewisAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private LewisSecurityProperties lewisSecurityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登陆成功！");
        if (LoginType.JSON.equals(lewisSecurityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            super.onAuthenticationSuccess(request,response,authentication);
        }

    }
}
