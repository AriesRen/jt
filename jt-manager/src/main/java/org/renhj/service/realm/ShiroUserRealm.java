package org.renhj.service.realm;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.renhj.dao.SysUserDao;
import org.renhj.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserDao userDao;

    /**
     * 实现认证方法的获取和封装
     * @param principalCollection 认证token 凭证
     * @return authorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1、获取用户信息
        // 1.1 获取用户名
        // 1.2 通过用户名从数据库查询用户信息
        // 1.3、根据用户ID查询角色信息
        // 1.4、根据角色信息查询菜单信息
        // 1.5、根据菜单信息查询权限信息
        //5.对用户权限信息进行封装。
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        return info;//将此数据返回给授权管理器
    }

    /**
     * 实现授权方法的获取的封装
     * @param authenticationToken 认证token
     * @return authenticationInfo
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1、获取认证信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 1.1 获取用户名
        String username = token.getUsername();
        // 1.2 通过用户名查询用户
        SysUser user = userDao.findUserByUsername(username);
        if (user == null){
            throw new UnknownAccountException("无效的用户名或密码！");
        }
        if (user.getStatus() == 0){
            throw new  DisabledAccountException("账户未激活！");
        }
        if (user.getStatus() == 2){
            throw new LockedAccountException("账户已锁定");
        }
        // 1.3、判断输入的密码和数据库中的密码是否符合
        String password = String.valueOf(token.getPassword());
        if (!user.getPassword().equals(password)){
            throw new AuthenticationException("无效的用户名或密码!");
        }
        // 2、对用户信息封装为AuthenticationInfo

        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        return new SimpleAuthenticationInfo(
                user,                 // 系统用户主身份
                user.getPassword(),  // 用户密码
                salt,                 // 密码加密的盐
                getName()            // realmName
        ); // 经用户数据返回给认证管理器，认证管理器会对用户的输入信息和info数据库中的信息进行比对
    }
}
