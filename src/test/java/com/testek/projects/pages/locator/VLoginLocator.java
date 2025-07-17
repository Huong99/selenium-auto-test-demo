package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class VLoginLocator extends BaseLocator{
    public VLoginLocator(){
    }

    String edtUserName = "ID|normal_login_username";
    String edtPassword = "ID|normal_login_password";
    String btnLogin = "//button[@type='submit']";
}
