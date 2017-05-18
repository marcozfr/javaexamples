package com.example.ws.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.ws.rs.NameBinding;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@NameBinding
public @interface MaxAge {
	int value();
}
