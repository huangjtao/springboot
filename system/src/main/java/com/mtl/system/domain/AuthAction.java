package com.mtl.system.domain;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Data
@Table(name = "mtl_auth_action")
@ApiModel(value = "AuthAction对象", description = "AuthAction对象")
public class AuthAction implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id
  private Integer actid;
  private String name;
  private String type;
  private String objvalue;
  private Integer choose;


}
