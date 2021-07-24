package com.sbx.app.work.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
* <p>
* 系统角色
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysRoleVO对象",description = "系统角色接口返回参数")
public class SysRoleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "是否超级角色")
    private Boolean superFlag;

    @ApiModelProperty(value = "角色类型 0运营管理角色")
    private Integer roleType;

    @ApiModelProperty(value = "全联动菜单id")
    private List<Long> menuIds;

    @ApiModelProperty(value = "半联动菜单id")
    private List<Long> halfMenuIds;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
