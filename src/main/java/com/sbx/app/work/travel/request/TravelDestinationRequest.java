package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 区域目的地
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelDestinationRequest对象",description = "区域目的地接口请求参数")
public class TravelDestinationRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "区域id")
    private Long regionId;

    @ApiModelProperty(value = "目的地名称")
    private String destinationName;

    @ApiModelProperty(value = "是否热门")
    private Boolean hotFlag;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否启用 1启用 0未启用")
    private Boolean enableFlag;


}
