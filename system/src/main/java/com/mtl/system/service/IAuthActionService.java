package com.mtl.system.service;

import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.AuthAction;

import java.util.List;

/**
 *  服务类
 *
 * @author lsc
 * @since 2019-03-26
 */
public interface IAuthActionService {

    AuthAction findById(Integer actid);

    Page<AuthAction> findPage(Integer page,Integer size);

    int saveOrUpdate(AuthAction authAction);

    int deleteBatch(List<Integer> ids);


}
