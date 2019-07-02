package com.mtl.system.mapper;

import com.mtl.system.domain.RoleAuth;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 * 角色菜单表 Mapper 接口
 *
 * @author lsc
 * @since 2019-04-14
 */
@Repository
public interface RoleAuthMapper  extends BaseMapper<RoleAuth>, IdListMapper<RoleAuth,Integer>{
}
