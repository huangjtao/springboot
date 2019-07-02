package com.mtl.member.mapper;

import com.mtl.member.domain.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;
import java.util.Map;

/**
 * 会员管理 Mapper 接口
 *
 * @author lsc
 * @since 2019-06-26
 */
@Repository
public interface MemberMapper  extends BaseMapper<Member>, IdListMapper<Member,Integer>{
    /**
     *
     * @param param
     * @return
     */
    List<Member> selectPage(Map<String,Object>param);
}
