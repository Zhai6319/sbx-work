package com.sbx.app.work.product.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 区域目的地
* </p>
*
* @author Z.jc
* @since 2021-07-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProductRegionDestinationVO对象",description = "区域目的地接口返回参数")
public class ProductRegionDestinationVO implements Serializable {
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
