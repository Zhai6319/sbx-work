package com.sbx.app.work.product.repository;

import com.sbx.app.product.api.IProductDeclareApi;
import com.sbx.app.product.dto.ProductDeclareDTO;
import com.sbx.app.product.params.ProductDeclareParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品声明 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@Service
public class ProductDeclareRepository {


    @DubboReference
    private IProductDeclareApi iProductDeclareApi;

    /**
     * 分页查询产品声明
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<ProductDeclareDTO> page(ProductDeclareParam param){
        return iProductDeclareApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取产品声明
     * @param id    用户ID
     * @return      返回产品声明
     */
    public ProductDeclareDTO detail(Long id){
        return iProductDeclareApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建产品声明
     * @param productDeclareDTO  产品声明
     * @return              返回创建数据id
     */
    public Long create(ProductDeclareDTO productDeclareDTO){
        return iProductDeclareApi.create(productDeclareDTO).computeDataOrFailThrow();
    }

    /**
     * 修改产品声明
     * @param productDeclareDTO  产品声明
     * @return              返回修改结果
     */
    public Boolean update(ProductDeclareDTO productDeclareDTO) {
        return iProductDeclareApi.update(productDeclareDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除产品声明
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iProductDeclareApi.delById(id).computeDataOrFailThrow();
    }

}