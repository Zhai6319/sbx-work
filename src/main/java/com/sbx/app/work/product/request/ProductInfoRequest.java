package com.sbx.app.work.product.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
* <p>
* 产品信息
* </p>
*
* @author Z.jc
* @since 2021-07-24
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ProductInfoRequest对象",description = "产品信息接口请求参数")
public class ProductInfoRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "声明id")
    private Long declareId;

    @ApiModelProperty(value = "退款声明id")
    private Long refundDeclareId;

    @ApiModelProperty(value = "安全须知")
    private Long safetyNoticeId;

    @ApiModelProperty(value = "物资准备模版id")
    private Long cargoReadyId;

    @ApiModelProperty(value = "区域id")
    private Long regionId;

    @ApiModelProperty(value = "目的地id")
    private Long destinationId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品描述")
    private String description;

    @ApiModelProperty(value = "最大人数")
    private Integer maxPeople;

    @ApiModelProperty(value = "最小年龄")
    private Integer minAge;

    @ApiModelProperty(value = "最大年龄")
    private Integer maxAge;

    @ApiModelProperty(value = "出行天数")
    private Integer days;

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

    @ApiModelProperty(value = "拓展属性 fee_includes  费用包含 fee_not_includes费用不包含，about_local关于本地 video_url 视频地址 images 图片地址列表")
    private String attribute;


}
