package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysCategory;

import java.util.List;

public interface SysCategoryDao {
    SysCategory findCategoryById(Long id);

    int getRowCount(@Param("search")String searchItem);

    List<SysCategory> findCategoriesWithPage(@Param("startIndex")Integer startIndex,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("search")String searchItem);

    int saveCategory(SysCategory cate);

    int deleteCategoryById(Long id);
}
