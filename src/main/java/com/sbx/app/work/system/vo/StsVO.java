package com.sbx.app.work.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/1/7
 */
@Data
@ApiModel(value = "StsVO对象",description = "sts授权信息")
public class StsVO implements Serializable {
    private static final long serialVersionUID = -4122414557856510858L;

    @ApiModelProperty(value = "密钥令牌",required = true)
    private String securityToken;

    @ApiModelProperty(value = "访问密钥",required = true)
    private String accessKeySecret;

    @ApiModelProperty(value = "访问key",required = true)
    private String accessKeyId;

    @ApiModelProperty(value = "过期时间",required = true)
    private LocalDateTime expiration;

    @ApiModelProperty(value = "阿里oss key",required = true)
    private String objectName;

    @ApiModelProperty(value = "签名",required = true)
    private String signature;

    @ApiModelProperty(value = "签名体",required = true)
    private String policyText;


}
