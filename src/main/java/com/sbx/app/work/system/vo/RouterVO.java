package com.sbx.app.work.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sbx.app.work.auth.vo.UserNavigationMetaVO;
import com.sbx.core.model.node.INode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/3
 */
@Data
public class RouterVO implements Serializable {
    private static final long serialVersionUID = -8489444963882446304L;

    @ApiModelProperty(value = "导航id",required = true)
    private Long id;

    @ApiModelProperty(value = "前端路由",required = true)
    private String router;

    @ApiModelProperty(value = "导航父级id",required = true)
    private Long parentId;

    @ApiModelProperty(value = "导航名称",required = true)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "导航元数据",required = true)
    private UserNavigationMetaVO meta;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(value = "导航转发路由",required = true)
    private String redirect;

    @ApiModelProperty(value = "导航组件",required = true)
    private String component;

}
