package com.mtl.system.mapper;

import com.mtl.system.domain.Menu;
import com.mtl.system.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author lsc
 * @since 2019-03-26
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu>{

    List<MenuVO> authMenu(@Param("ids") String ids);

    List<Menu> authMenuList(@Param("ids") String ids);

    List<String> authMenuIds(Integer id);

    int findByParentId(Integer id);

    /*
  获取角色权限
  * */
    List<MenuVO> MenuTreeByRole(Integer roleId);
}
