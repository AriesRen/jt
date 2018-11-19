package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysItem;
import org.renhj.entity.SysUser;

import java.util.List;

public interface SysItemDao {
    SysItem findItemById(Integer id);

    List<SysItem> findItemByTitleWithPage(@Param("startIndex") Integer startIndex,
                                   @Param("pageSize")Integer pageSize,
                                   @Param("title")String title);

    int getRowCount(@Param("title")String title);

    int saveItem(SysItem item);

    int deleteTitleById(Integer id);
}
