package com.lewis.security.core.properties;

/**
 * Created by Administrator on 2017/9/19.
 */
public class BrowserProperties {

    private String loginPage;

    private LoginType loginType=LoginType.REDIRECT;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
