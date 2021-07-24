package com.sbx.app.work.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 系统标签
* </p>
*
* @author Z.jc
* @since 2021-07-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysTagVO对象",description = "系统标签接口返回参数")
public class SysTagVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "标签名称")
    private String tagName;

    @ApiModelProperty(value = "标签类型 1用户标签 2产品标签")
    private Integer tagType;

    @ApiModelProperty(value = "启用标识")
    private Boolean enableFlag;


}
