package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysCategoryDao;
import org.renhj.entity.SysCategory;
import org.renhj.service.SysCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysCategoryServiceImpl implements SysCategoryService {
    @Autowired
    private SysCategoryDao cateDao;

    @Override
    public PageObject<SysCategory> findCategoryWithPage(String searchText, Integer pageCurrent, Integer pageSize) {
        // TODO: 加入缓存 判断参数
        List<SysCategory> list = cateDao.findCategoriesWithPage((pageCurrent-1)*pageSize, pageSize, searchText);
        System.out.println(list);
        int row = cateDao.getRowCount(searchText);
        PageObject<SysCategory> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCount((row-1)/pageSize+1);
        pageObject.setRow(row);
        pageObject.setRecords(list);
        return pageObject;
    }

    @Override
    public int deleteCategory(Long id) {
        return cateDao.deleteCategoryById(id);
    }

    @Override
    public int saveCategory(SysCategory cate) {
        cate.setCreatedTime(new Date());
        cate.setUpdatedTime(cate.getCreatedTime());
        cate.setCreatedUser("admin");
        cate.setUpdatedUser("admin");
        return cateDao.saveCategory(cate);
    }

    @Override
    public SysCategory findCategoryById(Long id) {
        return cateDao.findCategoryById(id);
    }
}
