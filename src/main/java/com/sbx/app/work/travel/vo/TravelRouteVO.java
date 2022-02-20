package com.sbx.app.work.travel.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* <p>
* 旅行线路
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TravelRouteVO对象",description = "旅行线路接口返回参数")
public class TravelRouteVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "区域id")
    private Long regionId;

    @ApiModelProperty(value = "目的地id")
    private Long destinationId;

    @ApiModelProperty(value = "线路名称")
    private String routeName;

    @ApiModelProperty(value = "线路描述")
    private String description;

    @ApiModelProperty(value = "视频链接")
    private String videoUrl;

    @ApiModelProperty(value = "主图地址")
    private String mainImg;

    @ApiModelProperty(value = "轮播图")
    private String images;

    @ApiModelProperty(value = "出行天数")
    private Integer days;

    @ApiModelProperty(value = "最小年龄")
    private Integer minAge;

    @ApiModelProperty(value = "最大年龄")
    private Integer maxAge;

    @ApiModelProperty(value = "限制人数")
    private Integer maxPeopleNum;

    @ApiModelProperty(value = "集合地点")
    private String gatherPlace;

    @ApiModelProperty(value = "集合地点经度")
    private BigDecimal gatherPlaceLongitude;

    @ApiModelProperty(value = "集合地点纬度")
    private BigDecimal gatherPlaceLatitude;

    @ApiModelProperty(value = "解散地点")
    private String dissolutionPlace;

    @ApiModelProperty(value = "解散地点经度")
    private BigDecimal dissolutionPlaceLongitude;

    @ApiModelProperty(value = "解散地点纬度")
    private BigDecimal dissolutionPlaceLatitude;

    @ApiModelProperty(value = "线路亮点")
    private String highlights;


}
