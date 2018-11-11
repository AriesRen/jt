package org.renhj.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.renhj.dao.SysUserDao;
import org.renhj.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    SysUserDao userDao;

    /**
     * 实现认证数据的获取和封装
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1、获取客户端提交的用户信息
        UsernamePasswordToken token = (UsernamePasswordToken) principalCollection;
        String username = token.getUsername();
        // 2、基于用户提交的信息从数据库中查询用户信息
        SysUser user = userDao.findUserByUsername(username);
        // 3、判断用户
        //（1）是否存在用户
        if (user == null) throw new AuthenticationException("用户不存在！");
        //      （2）用户锁定状态
        //      （3）封装用户

//        SimpleAuthorizationInfo userInfo = new SimpleAuthorizationInfo(
//                user,  //系统指定的主身份
//                token.getPassword(), //数据库中已经加密的密码
//                "",
//                getName()
//        );
        SimpleAuthorizationInfo userInfo;
        userInfo = new SimpleAuthorizationInfo();

        return userInfo;
    }

    /**
     * 实现授权数据的获取和封装
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
