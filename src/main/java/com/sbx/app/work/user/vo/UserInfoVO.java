package com.sbx.app.work.user.vo;

import com.sbx.app.work.system.vo.SysRoleVO;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserInfoVO对象",description = "用户信息接口返回参数")
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别 0保密 1男 2女")
    private Integer gender;

    @ApiModelProperty(value = "性别 文字描述")
    private String genderName;

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

    @ApiModelProperty(value = "启用状态")
    private Boolean enableFlag;

    @ApiModelProperty(value = "是否为超级管理员 0否 1是")
    private Boolean superAdmin;

    @ApiModelProperty(value = "来源 0pc 1微信小程序 2支付宝小程序 3ios 4安卓")
    private Integer source;

    @ApiModelProperty(value = "来源名称")
    private String sourceName;

    @ApiModelProperty(value = "用户角色id列表")
    private List<Long> roleIds;

    @ApiModelProperty(value = "用户角色列表")
    private List<SysRoleVO> roleList;



}
