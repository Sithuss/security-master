package com.example.securitymaster.security.config;

import org.hibernate.query.sqm.mutation.internal.temptable.GlobalTemporaryTableMutationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.awt.geom.AffineTransform;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        AffirmativeBased affirmativeBased = (AffirmativeBased) super.accessDecisionManager();
        affirmativeBased.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));
        return affirmativeBased;
    }
}
