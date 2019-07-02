package com.mtl.system.mapper;

import com.mtl.system.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 * 角色表 Mapper 接口
 *
 * @author lsc
 * @since 2019-04-14
 */
@Repository
public interface RoleMapper  extends BaseMapper<Role>, IdListMapper<Role,Integer>{
    List<Role> selectByCondition(@Param("searchKey") String searchKey);

    /*
    查找角色有没有关联的用户
    * */
    Integer selectAdminByRole(@Param("roleId") Integer roleId);
}
