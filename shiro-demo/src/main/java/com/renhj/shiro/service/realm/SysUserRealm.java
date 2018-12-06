package com.renhj.shiro.service.realm;

import com.renhj.shiro.entity.SysUser;
import com.renhj.shiro.mapper.SysUserMapper;
import org.apache.catalina.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class SysUserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserMapper userMapper;

    /**授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser user = userMapper.findUserByUsername(username);
        System.out.println("SysUserRealm "+ user);
        if (user==null) throw new AuthenticationException("用户不存在！");
        if (user.getStatus()==0) throw new AuthenticationException("账户未激活！");
        if (user.getStatus()==2) throw new AuthenticationException("账户已锁定，请联系管理员解锁！");

        ByteSource byteSalt = ByteSource.Util.bytes(user.getSalt());
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                byteSalt,
                getName()
        );
    }
}
