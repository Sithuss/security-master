package com.example.securitymaster.security.annotation;

import com.example.securitymaster.security.SecurityRoles;
import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.securitymaster.security.SecurityRoles.ROLES_PREFIX;
import static com.example.securitymaster.security.SecurityRoles.ROLES_ADMIN;
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Secured({ROLES_PREFIX + ROLES_ADMIN})
public @interface SuperAdmin {
}
