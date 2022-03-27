package com.sbx.app.work.travel.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
* 分组查询
* </p>
*
* @author Z.jc
* @since 2022-03-07
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TravelGroupVO对象",description = "分组查询接口返回参数")
public class TravelGroupVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "分组名称")
    private String groupName;

    @ApiModelProperty(value = "最小天数")
    private Integer minDays;

    @ApiModelProperty(value = "最大天数")
    private Integer maxDays;

    @ApiModelProperty(value = "启用标识")
    private Boolean enableFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;




}
