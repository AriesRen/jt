package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysUser;

public interface SysUserService {
    /**
     * 分页获取用户信息
     * @param username 用户名模糊查询
     * @param pageCurrent 当前页
     * @param pageSize 每页大小
     * @return 分页对象
     */
    PageObject<SysUser> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize);

    /**
     * 添加用户
     * @param user user对象
     * @return 返回添加后的用户信息
     */
    SysUser saveUser(SysUser user);

    /**
     * 删除用户
     * @param id 要删除用户的id
     * @return 影响的行数
     */
    int deleteUser(Long id);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    SysUser findUserById(Long id);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 更新后的用户信息
     */
    SysUser updateUser(SysUser user);
}
