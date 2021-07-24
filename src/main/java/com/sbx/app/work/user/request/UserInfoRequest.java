package com.sbx.app.work.user.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
* <p>
* 用户信息
* </p>
*
* @author Z.jc
* @since 2021-06-26
*/
@Data
@Accessors(chain = true)
@ApiModel(value = "UserInfoRequest对象",description = "用户信息接口请求参数")
public class UserInfoRequest implements Serializable {
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

    @ApiModelProperty(value = "md5加密的密码")
    private String password;

    @ApiModelProperty(value = "角色id列表")
    private List<Long> roleIds;

}
