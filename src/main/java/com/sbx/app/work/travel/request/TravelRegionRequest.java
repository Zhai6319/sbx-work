package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 区域信息
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelRegionRequest对象",description = "区域信息接口请求参数")
public class TravelRegionRequest extends Query {
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
