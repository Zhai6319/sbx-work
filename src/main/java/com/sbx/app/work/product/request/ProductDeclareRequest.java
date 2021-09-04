package com.sbx.app.work.product.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 产品声明
* </p>
*
* @author Z.jc
* @since 2021-07-24
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ProductDeclareRequest对象",description = "产品声明接口请求参数")
public class ProductDeclareRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "声明类型 1产品声明 2退款声明 3安全须知 4物资准备")
    private Integer declareType;

    @ApiModelProperty(value = "声明名称")
    private String declareName;

    @ApiModelProperty(value = "声明内容")
    private String content;


}
