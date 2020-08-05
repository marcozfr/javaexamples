package com.example.azureaadauthservice;

import com.microsoft.aad.msal4j.IAuthenticationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
public class HelloController {

    @Autowired
    MsalAuthHelper msalAuthHelper;

    @Autowired
    //@PreAuthorize("hasRole('Company')")
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/token")
    public String getToken() throws Exception {
        IAuthenticationResult result = msalAuthHelper.getAccessTokenByClientCredentialGrant();
        return result.accessToken();
    }
}
