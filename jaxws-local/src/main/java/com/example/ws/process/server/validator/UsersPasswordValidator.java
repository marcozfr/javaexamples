package com.example.ws.process.server.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback.DigestPasswordRequest;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidationException;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidator;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PlainTextPasswordRequest;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.Request;

public class UsersPasswordValidator implements PasswordValidator{
    
    private Logger logger = LoggerFactory.getLogger(UsersPasswordValidator.class);

    @Override
    public boolean validate(Request arg0) throws PasswordValidationException {
        if(((DigestPasswordRequest)arg0).getUsername().equals("adm")){
            logger.info("Validating digest password: user is adm");
            return true;
        }else if(((PlainTextPasswordRequest)arg0).getUsername().equals("adm")){
            logger.info("Validating plain text password: user is adm");
            return true;
        }else{
            return false;
        }
    }

}
