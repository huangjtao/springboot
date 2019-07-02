package com.mtl.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.AuthAction;
import com.mtl.system.mapper.AuthActionMapper;
import com.mtl.system.service.IAuthActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Service
public class AuthActionServiceImpl implements IAuthActionService {

    @Autowired
    private AuthActionMapper authActionMapper;

    @Override
    public AuthAction findById(Integer actid) {
        return authActionMapper.selectByPrimaryKey(actid);
    }

    @Override
    public Page<AuthAction> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<AuthAction> authActions=authActionMapper.selectAll();
        return new Page<>(authActions);
    }

    @Override
    public int saveOrUpdate(AuthAction authAction) {
        if(authAction.getActid()!=null){
            return authActionMapper.updateByPrimaryKey(authAction);
        }
        return authActionMapper.insert(authAction);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return authActionMapper.deleteByIdList(ids);
    }
}
