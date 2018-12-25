package org.renhj.manager.service.impl;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbUserMapper;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public Page<?> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        Integer total = userMapper.selectTotalByUsername(username);
        List<?> list = userMapper.selectUsersByUsernameWithPage(username, (pageCurrent-1)*pageSize, pageSize);
        Integer pageCount = (total-1)/pageSize + 1;
        return new Page<>(total,pageSize,pageCurrent,pageCount,list);
    }

    @Override
    public int saveUser(TbUser user) {
        // 添加用户
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());

        return userMapper.insert(user);
    }

    @Override
    public Long deleteUserById(String id) {
        return null;
    }

    @Override
    public TbUser updateUser(TbUser user) {
        return null;
    }

}
