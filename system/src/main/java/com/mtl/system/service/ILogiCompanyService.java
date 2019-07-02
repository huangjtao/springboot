package com.mtl.system.service;

import com.mtl.system.domain.LogiCompany;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-24
 */
public interface ILogiCompanyService {

        LogiCompany findById(Integer id);

        Page<LogiCompany> findPage(Integer page,Integer size);

        int saveOrUpdate(LogiCompany logiCompany);

        int deleteBatch(List<Integer> ids);
}
