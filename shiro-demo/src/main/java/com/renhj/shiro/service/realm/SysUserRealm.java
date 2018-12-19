package com.renhj.shiro.service.realm;

import com.renhj.shiro.entity.SysUser;
import com.renhj.shiro.mapper.SysUserMapper;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class SysUserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        System.out.println("授权:" + user);
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser user = userMapper.findUserByUsername(username);
        System.out.println("认证： " + user);
        if (user == null) throw new AuthenticationException("用户不存在！");
        if (user.getStatus() == 0) throw new AuthenticationException("账户未激活！");
        if (user.getStatus() == 2) throw new AuthenticationException("账户已锁定，请联系管理员解锁！");

        ByteSource byteSalt = ByteSource.Util.bytes(user.getSalt());
        AuthenticationInfo info =  new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                byteSalt,
                getName()
        );
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return info;
    }
}
