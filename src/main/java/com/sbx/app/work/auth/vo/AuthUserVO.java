package com.sbx.app.work.auth.vo;

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
 * @since 2020/12/29
 */
@Data
@ApiModel(value = "AuthUserVO对象",description = "授权用户信息")
public class AuthUserVO implements Serializable {
    private static final long serialVersionUID = 8157892857893619979L;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "用户登陆令牌")
    private String token;

    @ApiModelProperty(value = "令牌创建时间")
    private LocalDateTime tokenTime;

    @ApiModelProperty(value = "令牌有效时间")
    private Long expiredSeconds;
}
