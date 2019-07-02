package com.mtl.system.mapper;

import com.mtl.system.domain.Settings;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author lsc
 * @since 2019-03-26
 */
@Repository
public interface SettingsMapper  extends BaseMapper<Settings>, IdListMapper<Settings,Integer>{
}
