package com.mtl.system.security;


import com.mtl.common.tool.utils.StringUtil;
import com.mtl.system.domain.AdminUser;
import com.mtl.system.domain.Menu;
import com.mtl.system.domain.Role;
import com.mtl.system.security.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lsc
 */
@Slf4j
public class SecurityUserDetails extends AdminUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUserDetails(AdminUser user) {

        if(user!=null) {
            this.setUserid(user.getUserid());
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setState(user.getState());
            this.setRoles(user.getRoles());
            this.setPermissions(user.getPermissions());
        }
    }

    /**
     * 添加用户拥有的权限和角色
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            List<Menu> permissions = this.getPermissions();
            // 添加请求权限
            if(permissions!=null&&permissions.size()>0){
                for (Menu permission : permissions) {
                    if(CommonConstant.PERMISSION_OPERATION.equals(permission.getMenutype())
                            &&StringUtil.isNotBlank(permission.getTitle())
                            &&StringUtil.isNotBlank(permission.getUrl())) {

                        authorityList.add(new SimpleGrantedAuthority(permission.getTitle()));
                    }
                }
            }
            // 添加角色
            List<Role> roles = this.getRoles();
            if(roles!=null&&roles.size()>0){
                // lambda表达式
                roles.forEach(item -> {
                    if(StringUtil.isNotBlank(item.getRoleName())){
                        authorityList.add(new SimpleGrantedAuthority(item.getRoleName()));
                    }
                });
            }
            return authorityList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    /**
     * 是否禁用
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return CommonConstant.USER_STATUS_LOCK.equals(this.getState()) ? false : true;
    }

    /**
     * 密码是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    /**
     * 是否启用
     * @return
     */
    @Override
    public boolean isEnabled() {

        return CommonConstant.USER_STATUS_NORMAL.equals(this.getState()) ? true : false;
    }
}