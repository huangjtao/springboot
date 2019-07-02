package com.mtl.system.service.impl;

import com.mtl.system.domain.Department;
import com.mtl.system.mapper.DepartmentMapper;
import com.mtl.system.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-04-06
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department findById(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Department> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Department> departments=departmentMapper.selectAll();
        return new Page<>(departments);
    }

    @Override
    public int saveOrUpdate(Department department) {
        if(department.getId()!=null){
        return departmentMapper.updateByPrimaryKey(department);
        }
        return departmentMapper.insert(department);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return departmentMapper.deleteByIdList(ids);
    }
}
