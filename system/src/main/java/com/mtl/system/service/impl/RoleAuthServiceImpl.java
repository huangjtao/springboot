package com.mtl.system.service.impl;

import com.mtl.system.domain.RoleAuth;
import com.mtl.system.mapper.RoleAuthMapper;
import com.mtl.system.service.IRoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 * 角色菜单表 服务实现类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Service
public class RoleAuthServiceImpl implements IRoleAuthService {

    @Autowired
    private RoleAuthMapper roleAuthMapper;

    @Override
    public RoleAuth findById(Integer id) {
        return roleAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<RoleAuth> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<RoleAuth> roleAuths=roleAuthMapper.selectAll();
        return new Page<>(roleAuths);
    }

    @Override
    public int saveOrUpdate(RoleAuth roleAuth) {
        if(roleAuth.getId()!=null){
        return roleAuthMapper.updateByPrimaryKey(roleAuth);
        }
        return roleAuthMapper.insert(roleAuth);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return roleAuthMapper.deleteByIdList(ids);
    }
}
