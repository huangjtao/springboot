package com.mtl.system.service;

import com.mtl.system.domain.Role;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 * 角色表 服务类
 *
 * @author lsc
 * @since 2019-04-14
 */
public interface IRoleService {

        Role findById(Integer id);

        Page<Role> findPage(Integer page,Integer size,String search);

        int saveOrUpdate(Role role);

        int deleteBatch(List<Integer> ids);
}
