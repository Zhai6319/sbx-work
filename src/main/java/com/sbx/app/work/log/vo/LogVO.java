package com.sbx.app.work.log.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
* 日志记录
* </p>
*
* @author Z.jc
* @since 2021-10-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "LogVO对象",description = "日志记录接口返回参数")
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户类型名称")
    private String userTypeName;

    @ApiModelProperty(value = "日志标题")
    private String logTitle;

    @ApiModelProperty(value = "请求参数")
    private String params;

    @ApiModelProperty(value = "日志内容")
    private String content;

    @ApiModelProperty(value = "日志类型 0系统日志")
    private Integer logType;

    @ApiModelProperty(value = "请求方法")
    private String method;

    @ApiModelProperty(value = "方法类")
    private String methodClass;

    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @ApiModelProperty(value = "请求ip")
    private String remoteIp;

    @ApiModelProperty(value = "请求地址")
    private String requestUri;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
