package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 分组查询
* </p>
*
* @author Z.jc
* @since 2022-03-07
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelGroupRequest对象",description = "分组查询接口请求参数")
public class TravelGroupRequest extends Query {
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


}
