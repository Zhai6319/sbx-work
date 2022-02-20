package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 旅游路线亮点
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelRouteHighlightsRequest对象",description = "旅游路线亮点接口请求参数")
public class TravelRouteHighlightsRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "区域id")
    private Long regionId;

    @ApiModelProperty(value = "目的地id")
    private Long destinationId;

    @ApiModelProperty(value = "亮点名称")
    private String highlightsName;

    @ApiModelProperty(value = "亮点内容")
    private String content;


}
