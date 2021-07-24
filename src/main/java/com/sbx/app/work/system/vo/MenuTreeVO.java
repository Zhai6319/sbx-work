package com.sbx.app.work.system.vo;

import com.sbx.core.model.node.INode;
import com.sbx.core.tool.util.CollectionUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/1/14
 */
@Data
@ApiModel(value = "MenuTreeVO对象",description = "树形菜单返回参数")
public class MenuTreeVO extends SysMenuVO implements INode {
    private static final long serialVersionUID = 4805555254836044019L;

    @ApiModelProperty(value = "子节点菜单",required = true)
    private List<INode> children;

    @ApiModelProperty(value = "是否存在子节点",required = true)
    private Boolean hasChildren;







    public List<INode> getChildren() {
        if (Objects.isNull(children)) {
            children = Lists.newArrayList();
        }
        return children;
    }

    @Override
    public Boolean getHasChildren() {
        return CollectionUtil.isNotEmpty(this.children);
    }
}
