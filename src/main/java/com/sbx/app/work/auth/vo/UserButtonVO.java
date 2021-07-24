package com.sbx.app.work.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/1/6
 */
@Data
@ApiModel(value = "UserButtonVO对象",description = "按钮信息")
public class UserButtonVO implements Serializable {
    private static final long serialVersionUID = -621644322368251961L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "位置")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "图标")
    private String icon;

}
