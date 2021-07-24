package com.sbx.app.work.user.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 用户信息
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserInfoQueryRequest对象",description = "用户信息接口请求参数")
public class UserInfoQueryRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别 0保密 1男 2女")
    private Integer gender;

    @ApiModelProperty(value = "手机号 加密存储")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "生日")
    private String birthday;

    @ApiModelProperty(value = "头像")
    private String portrait;

    @ApiModelProperty(value = "用户类型 1管理员 2c端用户")
    private Integer userType;

    @ApiModelProperty(value = "是否为超级管理员 0否 1是")
    private Boolean superAdmin;

    @ApiModelProperty(value = "来源 0pc 1微信小程序 2支付宝小程序 3ios 4安卓")
    private String source;


}
