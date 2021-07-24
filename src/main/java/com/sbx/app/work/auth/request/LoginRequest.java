package com.sbx.app.work.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "LoginRequest对象",description = "登陆请求参数")
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -4886778238712420402L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "验证码",required = true)
    private String code;

    @ApiModelProperty(value = "验证码key",required = true)
    private String key;

    /**
     * @see com.sbx.app.user.enums.LoginMethodEnum
     */
    @ApiModelProperty(value = "登录方式",required = true)
    private Integer loginMethod;

}
