package com.sbx.app.work.applet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 小程序菜单栏
* </p>
*
* @author Z.jc
* @since 2022-03-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AppletNavVO对象",description = "小程序菜单栏接口返回参数")
public class AppletNavVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "导航名称")
    private String navName;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "当前选择图标")
    private String selectedIcon;

    @ApiModelProperty(value = "页面路径")
    private String pagePath;

    @ApiModelProperty(value = "业务类型")
    private Integer bizType;


}
