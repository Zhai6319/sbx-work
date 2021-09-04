package com.sbx.app.work.product.repository;

import com.sbx.app.product.api.IProductTripApi;
import com.sbx.app.product.dto.ProductTripDTO;
import com.sbx.app.product.params.ProductTripParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日行程介绍 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@Service
public class ProductTripRepository {


    @DubboReference
    private IProductTripApi iProductTripApi;

    /**
     * 分页查询每日行程介绍
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<ProductTripDTO> page(ProductTripParam param){
        return iProductTripApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取每日行程介绍
     * @param id    用户ID
     * @return      返回每日行程介绍
     */
    public ProductTripDTO detail(Long id){
        return iProductTripApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建每日行程介绍
     * @param productTripDTO  每日行程介绍
     * @return              返回创建数据id
     */
    public Long create(ProductTripDTO productTripDTO){
        return iProductTripApi.create(productTripDTO).computeDataOrFailThrow();
    }

    /**
     * 修改每日行程介绍
     * @param productTripDTO  每日行程介绍
     * @return              返回修改结果
     */
    public Boolean update(ProductTripDTO productTripDTO) {
        return iProductTripApi.update(productTripDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除每日行程介绍
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iProductTripApi.delById(id).computeDataOrFailThrow();
    }

}