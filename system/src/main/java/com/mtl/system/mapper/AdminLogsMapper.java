package com.mtl.system.mapper;

import com.mtl.system.domain.AdminLogs;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
/**
 *  Mapper 接口
 *
 * @author lsc
 * @since 2019-03-26
 */
@Repository
public interface AdminLogsMapper extends BaseMapper<AdminLogs> ,IdListMapper<AdminLogs,Long> {
}
