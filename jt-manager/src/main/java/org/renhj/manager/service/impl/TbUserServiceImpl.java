package org.renhj.manager.service.impl;

import org.apache.log4j.Logger;
import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbUserMapper;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.pojo.exception.ServiceException;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class TbUserServiceImpl implements TbUserService {
    private static final Logger log = Logger.getLogger(TbUserServiceImpl.class);
    private final TbUserMapper userMapper;

    @Autowired
    public TbUserServiceImpl(TbUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Page findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        log.info("查询用户总数");
        TbUser user = new TbUser();
        user.setUsername(username);
        Integer total = userMapper.selectTotalByUsername(username);
        log.info("查询用户列表");
        List<?> list = userMapper.selectUsersByUsernameWithPage(username, (pageCurrent - 1) * pageSize, pageSize);
        Integer pageCount = (total - 1) / pageSize + 1;
        log.info("返回分页对象数据");
        return new Page(total, pageSize, pageCurrent, pageCount, list);
    };

    public int saveUser(TbUser user) {
        // 1、判断参数是否为空
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new ServiceException("用户名或密码为空！");
        }

        // 2、根据username判断数据库中是否有相同的用户
        if (userMapper.selectOneByUsername(user.getUsername()) != null) {
            log.info("创建失败：用户名: " + user.getUsername() + "已存在!");
            throw new ServiceException("用户名称 username： " + user.getUsername() + " 已存在");
        }
        // 3、根据邮箱判断数据库中是否有相同用户
        if (userMapper.selectOneByEmail(user.getEmail()) != null){
            log.info("创建失败：邮箱: " + user.getEmail() + "已绑定用户!");
            throw new ServiceException("该邮箱： " + user.getEmail() + " 已绑定用户！");
        }
        // 4、添加用户
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        return userMapper.insertSelective(user);
    }

    public int deleteUserById(Long id) {
        if (userMapper.selectByPrimaryKey(id) == null) {
            log.error("删除失败！未找到此用户: " + id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        return userMapper.deleteByPrimaryKey(id);
    }

    public int updateUser(TbUser user) {
        if (userMapper.selectOne(user) == null) {
            log.error("删除失败！未找到此用户: " + user.getUsername());
            throw new ServiceException("Not Found this user: " + user.getUsername());
        }
        user.setUpdated(new Date());
        return userMapper.updateByPrimaryKey(user);
    }

    public int patchUser(Long id, TbUser user) {
        if (userMapper.selectByPrimaryKey(id) == null) {
            log.error("删除失败！未找到此用户: " + id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        System.out.println(user);
        user.setUpdated(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public TbUser findUserById(Long id) {
        TbUser user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            log.error("删除失败！未找到此用户: " + id);
            throw new ServiceException("Not Found this user id: " + id);
        }
        return user;
    }

    @Override
    public Boolean findUserByUsername(String username) {
        try {
            TbUser user = new TbUser();
            user.setUsername(username);
            TbUser selectUser = userMapper.selectOne(user);
            System.out.println(selectUser);
            return selectUser != null;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

}
