package com.mtl.member.service;

import com.mtl.member.domain.Member;
import com.mtl.common.tool.model.Page;
import java.util.List;
import java.util.Map;

/**
 * 会员管理 服务类
 *
 * @author lsc
 * @since 2019-06-26
 */
public interface IMemberService {

        Member findById(Integer id);

        Page<Member> findPage(Map<String,Object> param);

        int saveOrUpdate(Member member);

        int deleteBatch(List<Integer> ids);
}
