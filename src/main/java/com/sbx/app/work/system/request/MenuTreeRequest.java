package com.sbx.app.work.system.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/1/14
 */
@Data
@ApiModel(value = "MenuTreeRequest对象",description = "树形菜单请求参数")
public class MenuTreeRequest implements Serializable {
    private static final long serialVersionUID = -5505283941037748115L;

    @ApiModelProperty(value = "归属 0运营管理系统 1驿站")
    private Integer ascription;

    @ApiModelProperty(value = "归属 0菜单 1按钮")
    private Integer type;
}
