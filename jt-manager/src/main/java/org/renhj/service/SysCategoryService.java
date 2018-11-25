package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.entity.SysCategory;

public interface SysCategoryService {
    PageObject<SysCategory> findCategoryWithPage(String searchText, Integer pageCurrent,Integer pageSize);
    int deleteCategory(Long id);
    int saveCategory(SysCategory cate);
    SysCategory findCategoryById(Long id);
}
