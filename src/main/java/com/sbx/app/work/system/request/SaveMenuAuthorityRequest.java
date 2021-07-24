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
 * @since 2021/1/19
 */
@Data
@ApiModel(value = "SaveMenuAuthorityRequest对象",description = "保存菜单权限请求参数")
public class SaveMenuAuthorityRequest implements Serializable {
    private static final long serialVersionUID = 3653530149434673330L;


    @ApiModelProperty(value = "菜单id",required = true)
    private Long menuId;

    @ApiModelProperty(value = "所属模块",required = true)
    private String module;

    @ApiModelProperty(value = "权限列表",required = true)
    private List<SysAuthoritiesRequest> authorities;

}
