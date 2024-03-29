/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mtl.api.mapper;

import com.mtl.api.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 会员管理 Mapper 接口
 *
 * @author lsc
 * @since 2019-05-05
 */
@Repository
public interface MemberLoginMapper extends BaseMapper<Member>, IdListMapper<Member,Integer>{

    Member login(@Param("phone") String phone, @Param("password") String password);

    Member findById(@Param("id") Integer id);

    Member findByOpenId(@Param("openId") String openId);
}
