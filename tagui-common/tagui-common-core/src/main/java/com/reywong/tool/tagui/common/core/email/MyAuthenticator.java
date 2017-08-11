/**
 *
 * File Desc:    
 *
 * Product AB:   热风投资有限公司
 *
 * Module Name:  
 *
 * Author:       wangrui
 *
 * Create:       13-6-18-下午5:58
 *
 * History:      13-6-18-下午5:58 modify  by  wangrui
 */
package com.reywong.tool.tagui.common.core.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
    String userName = null;
    String password = null;

    public MyAuthenticator() {
    }

    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }

}
