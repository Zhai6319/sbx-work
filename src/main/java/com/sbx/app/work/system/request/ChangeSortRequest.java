package com.sbx.app.work.system.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/1/14
 */
@Data
@ApiModel(value = "ChangeSortRequest对象",description = "创建菜单请求参数")
public class ChangeSortRequest implements Serializable {
    private static final long serialVersionUID = -8871833363882185348L;

    @ApiModelProperty(value = "当前id")
    private Long id;

    @ApiModelProperty(value = "排序类型")
    private Integer sortType;

}
