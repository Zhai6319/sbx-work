package com.sbx.app.work.system.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/10
 */
@Data
@ApiModel(value = "SaveRoleRequest对象",description = "保存角色请求参数")
public class SaveRoleRequest implements Serializable {
    private static final long serialVersionUID = -9033592558830413694L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "模糊查询角色名称")
    private String likeRoleName;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "是否超级角色")
    private Boolean superFlag;

    @ApiModelProperty(value = "角色类型 0运营管理角色")
    private Integer roleType;

    @ApiModelProperty(value = "菜单id列表")
    private List<Long> menuIds;

    @ApiModelProperty(value = "半联动菜单")
    private List<Long> halfMenuIds;
}
