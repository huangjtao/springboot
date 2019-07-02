package com.mtl.system.mapper;

import com.mtl.system.domain.AuthAction;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.IdsMapper;

/**
 *  Mapper 接口
 *
 * @author lsc
 * @since 2019-03-26
 */
@Repository
public interface AuthActionMapper extends BaseMapper<AuthAction>, IdListMapper<AuthAction,Integer> {
}
