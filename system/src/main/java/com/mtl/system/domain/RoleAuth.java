package com.mtl.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
/**
 * 角色菜单表实体类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Data
@Table(name="mtl_role_auth")
@ApiModel(value = "RoleAuth对象", description = "角色菜单表")

public class RoleAuth implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id

  private Integer id;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
  
  private Integer roleId;
    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
  
  private Integer menuId;


}
