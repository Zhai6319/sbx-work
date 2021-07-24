package com.sbx.app.work.system.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 系统菜单
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysMenuRequest对象",description = "系统菜单接口请求参数")
public class SysMenuRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "父级id 0为当前菜单一级")
    private Long parentId;

    @ApiModelProperty(value = "菜单类型0菜单1按钮")
    private Integer menuType;

    @ApiModelProperty(value = "归属 0系统")
    private Integer ascription;

    @ApiModelProperty(value = "菜单标题")
    private String menuTitle;

    @ApiModelProperty(value = "前端路由")
    private String router;

    @ApiModelProperty(value = "菜单编码")
    private String menuCode;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "转发")
    private String redirect;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "菜单等级1一级2二级3三级")
    private Integer menuLevel;

    @ApiModelProperty(value = "是否展示0否1是")
    private Boolean showFlag;


}
