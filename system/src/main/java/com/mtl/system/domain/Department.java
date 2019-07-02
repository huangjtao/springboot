package com.mtl.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-04-06
 */
@Data
@Table(name="mtl_department")
@ApiModel(value = "Department对象", description = "Department对象")

public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id

  private Integer id;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
  
  private String departmentName;
    /**
     * 上级部门id
     */
    @ApiModelProperty(value = "上级部门id")
  
  private Integer parentId;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
  
  private Integer sort;
    /**
     * 部门负责人
     */
    @ApiModelProperty(value = "部门负责人")
  
  private Integer master;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
  
  private Date createTime;


}
