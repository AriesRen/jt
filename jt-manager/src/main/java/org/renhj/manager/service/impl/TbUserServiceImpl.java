package org.renhj.manager.service.impl;

import org.apache.log4j.Logger;
import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbUserMapper;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.pojo.exception.ServiceException;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TbUserServiceImpl implements TbUserService {
    private static final Logger log = Logger.getLogger(TbUserServiceImpl.class);
    @Autowired
    private TbUserMapper userMapper;

    public Page findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        log.info("查询用户总数");
        Integer total = userMapper.selectTotalByUsername(username);
        log.info("查询用户列表");
        List<?> list = userMapper.selectUsersByUsernameWithPage(username, (pageCurrent-1)*pageSize, pageSize);
        Integer pageCount = (total-1)/pageSize + 1;
        log.info("返回分页对象数据");
        return new Page(total,pageSize,pageCurrent,pageCount,list);
    }

    public int saveUser(TbUser user) {
        // 1、判断是否为空
        if (user.getUsername()==null || user.getPassword()==null ){
            log.info("登录失败： " + user.getUsername());
            throw new ServiceException("用户名或密码不能为空！");
        }
        if (userMapper.selectOne(user) != null){
            log.info("登录失败：该用户 " + user.getUsername() + "已存在!");
            throw new ServiceException("该用户 " + user.getUsername() +" 已存在");
        }
        // 添加用户
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        return userMapper.insert(user);
    }

    public int deleteUserById(Long id) {
        if (userMapper.selectByPrimaryKey(id) == null){
            log.error("删除失败！未找到此用户: "+ id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        return userMapper.deleteByPrimaryKey(id);
    }

    public int updateUser(TbUser user) {
        if (userMapper.selectOne(user) == null){
            log.error("删除失败！未找到此用户: "+ user.getUsername());
            throw new ServiceException("Not Found this user: "+ user.getUsername());
        }
        user.setUpdated(new Date());
        return userMapper.updateByPrimaryKey(user);
    }

    public int patchUser(Long id, TbUser user){
        if (userMapper.selectByPrimaryKey(id) == null){
            log.error("删除失败！未找到此用户: "+ id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        user.setId(id);
        user.setUpdated(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public TbUser findUserById(Long id) {
        TbUser user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            log.error("删除失败！未找到此用户: "+ id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        return user;
    }

}
