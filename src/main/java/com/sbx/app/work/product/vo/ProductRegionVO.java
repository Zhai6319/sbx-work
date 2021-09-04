package com.sbx.app.work.product.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 区域信息
* </p>
*
* @author Z.jc
* @since 2021-07-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProductRegionVO对象",description = "区域信息接口返回参数")
public class ProductRegionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "区域名称")
    private String regionName;

    @ApiModelProperty(value = "区域类型 1国内 2国际")
    private Integer regionType;

    @ApiModelProperty(value = "描述")
    private String description;


}
