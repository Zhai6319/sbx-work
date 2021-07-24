package com.sbx.app.work.user.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 用户登录
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserLoginRequest对象",description = "用户登录接口请求参数")
public class UserLoginRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "登陆类型 0密码 1微信openid 2支付宝userid")
    private Integer loginType;

    @ApiModelProperty(value = "微信联合id")
    private String unionId;

    @ApiModelProperty(value = "密钥")
    private String secretKey;


}
