package org.renhj.manager.service.impl;

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
    @Autowired
    private TbUserMapper userMapper;


    public Page<?> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        Integer total = userMapper.selectTotalByUsername(username);
        List<?> list = userMapper.selectUsersByUsernameWithPage(username, (pageCurrent-1)*pageSize, pageSize);
        Integer pageCount = (total-1)/pageSize + 1;
        return new Page<>(total,pageSize,pageCurrent,pageCount,list);
    }

    public int saveUser(TbUser user) {
        // 1、判断是否为空
        if (user.getUsername()==null || user.getPassword()==null ){
            throw new ServiceException("用户名或密码不能为空！");
        }
        TbUser isExist = userMapper.selectOne(user);
        if (isExist != null){
            throw new ServiceException("该用户已存在");
        }
        // 添加用户
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());

        return userMapper.insert(user);
    }

    public Long deleteUserById(String id) {
        return null;
    }


    public TbUser updateUser(TbUser user) {
        return null;
    }

}
