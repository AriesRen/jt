package com.renhj.shiro.configuration;

import com.renhj.shiro.entity.SysUser;
import com.renhj.shiro.service.realm.SysUserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public SysUserRealm sysUserRealm() {
        SysUserRealm realm = new SysUserRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }


    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(sysUserRealm());
        return securityManager;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(manager);

        Map<String, String> filterChain = new LinkedHashMap<>();
        filterChain.put("/logout", "logout");
        filterChain.put("/static/**", "anon");
        filterChain.put("/auth/login", "anon");
        filterChain.put("/auth/doLogin", "anon");
        filterChain.put("/auth/register", "anon");
        filterChain.put("/auth/doRegister", "anon");
        filterChain.put("/**", "authc");

        shiroFilter.setLoginUrl("/auth/login");
        shiroFilter.setSuccessUrl("/users");
        shiroFilter.setUnauthorizedUrl("/auth/unauth");
        shiroFilter.setFilterChainDefinitionMap(filterChain);
        return shiroFilter;
    }

}
