package com.sbx.app.work.applet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 域名应用授权
* </p>
*
* @author Z.jc
* @since 2022-05-20
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WebsiteAppEmpowerVO对象",description = "域名应用授权接口返回参数")
public class WebsiteAppEmpowerVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "域名")
    private String domainName;

    @ApiModelProperty(value = "授权应用")
    private String appId;


}
