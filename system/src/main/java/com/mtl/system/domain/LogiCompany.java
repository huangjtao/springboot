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
 * 实体类
 *
 * @author lsc
 * @since 2019-04-24
 */
@Data
@Table(name="mtl_logi_company")
@ApiModel(value = "LogiCompany对象", description = "LogiCompany对象")

public class LogiCompany implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id

  private Integer id;

  private String name;

  private String code;


}
