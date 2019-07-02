package com.mtl.system.service;

import com.mtl.system.domain.RoleAuth;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 * 角色菜单表 服务类
 *
 * @author lsc
 * @since 2019-04-14
 */
public interface IRoleAuthService {

        RoleAuth findById(Integer id);

        Page<RoleAuth> findPage(Integer page,Integer size);

        int saveOrUpdate(RoleAuth roleAuth);

        int deleteBatch(List<Integer> ids);
}
