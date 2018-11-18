package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysUserDao;
import org.renhj.entity.SysUser;
import org.renhj.exception.ServiceException;
import org.renhj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, timeout = 30)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageObject<SysUser> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {

        int rows = sysUserDao.getRowCount(username); // 记录数
        if (rows < 1){throw new ServiceException("没有记录！");}
        List<SysUser> users = sysUserDao.findUserWithPage((pageCurrent-1)*pageSize, pageSize, username);
        PageObject<SysUser> pageObject = new PageObject<>();
        pageObject.setRecords(users);
        pageObject.setRow(rows);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCount((rows - 1)/pageSize + 1);
        pageObject.setPageCurrent(pageCurrent);
        return pageObject;
    }

    @Override
    @Transactional(readOnly = false)
    public int saveUser(SysUser user) {
        return sysUserDao.saveUser(user);
    }
}
