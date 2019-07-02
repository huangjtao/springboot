package com.mtl.system.service;

import com.mtl.system.domain.Department;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-06
 */
public interface IDepartmentService {

        Department findById(Integer id);

        Page<Department> findPage(Integer page,Integer size);

        int saveOrUpdate(Department department);

        int deleteBatch(List<Integer> ids);
}
