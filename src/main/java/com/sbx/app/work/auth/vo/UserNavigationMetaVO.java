package com.sbx.app.work.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2020/12/29
 */
@Data
public class UserNavigationMetaVO implements Serializable {
    private static final long serialVersionUID = -6563085226828086505L;

    @ApiModelProperty(value = "导航图标")
    private String icon;

    @ApiModelProperty(value = "导航标题",required = true)
    private String title;

    @ApiModelProperty(value = "是否展示 true 是 false 不展示",required = true)
    private Boolean show;

    @ApiModelProperty(value = "按钮列表")
    private List<UserButtonVO> buttons;


}
