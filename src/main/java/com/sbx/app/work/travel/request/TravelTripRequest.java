package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 每日行程介绍
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelTripRequest对象",description = "每日行程介绍接口请求参数")
public class TravelTripRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "第几天")
    private Integer daySn;

    @ApiModelProperty(value = "拓展属性")
    private String attribute;


}
