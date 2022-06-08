package com.sbx.app.work.applet.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 域名应用授权
* </p>
*
* @author Z.jc
* @since 2022-05-20
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "WebsiteAppEmpowerRequest对象",description = "域名应用授权接口请求参数")
public class WebsiteAppEmpowerRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "域名")
    private String domainName;

    @ApiModelProperty(value = "授权应用")
    private String appId;


}
