package com.mtl.system.service.impl;

import com.mtl.system.domain.LogiCompany;
import com.mtl.system.mapper.LogiCompanyMapper;
import com.mtl.system.service.ILogiCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-04-24
 */
@Service
public class LogiCompanyServiceImpl implements ILogiCompanyService {

    @Autowired
    private LogiCompanyMapper logiCompanyMapper;

    @Override
    public LogiCompany findById(Integer id) {
        return logiCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<LogiCompany> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<LogiCompany> logiCompanys=logiCompanyMapper.selectAll();
        return new Page<>(logiCompanys);
    }

    @Override
    public int saveOrUpdate(LogiCompany logiCompany) {
        if(logiCompany.getId()!=null){
        return logiCompanyMapper.updateByPrimaryKey(logiCompany);
        }
        return logiCompanyMapper.insert(logiCompany);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return logiCompanyMapper.deleteByIdList(ids);
    }
}
