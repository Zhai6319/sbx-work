package com.sbx.app.work.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 系统权限
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysAuthoritiesVO对象",description = "系统权限接口返回参数")
public class SysAuthoritiesVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "菜单id")
    private Long menuId;

    @ApiModelProperty(value = "权限类型0系统1驿站")
    private Integer authorityType;

    @ApiModelProperty(value = "权限")
    private String authority;

    @ApiModelProperty(value = "权限方法")
    private String method;

    @ApiModelProperty(value = "所属模块")
    private String module;


}
