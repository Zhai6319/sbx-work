package com.sbx.app.work.system.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysRoleRequest对象",description = "系统角色接口请求参数")
public class SysRoleRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "主键id列表")
    private List<Long> ids;

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


}
