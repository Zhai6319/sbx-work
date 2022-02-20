package com.sbx.app.work.travel.request;

import com.sbx.core.model.params.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 旅行声明
* </p>
*
* @author Z.jc
* @since 2022-02-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TravelDeclareRequest对象",description = "旅行声明接口请求参数")
public class TravelDeclareRequest extends Query {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "声明名称")
    private String declareName;

    @ApiModelProperty(value = "展示名称")
    private String showName;

    @ApiModelProperty(value = "声明内容")
    private String content;


}
