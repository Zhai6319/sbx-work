package com.sbx.app.work.product.repository;

import com.sbx.app.product.api.IProductInfoApi;
import com.sbx.app.product.dto.ProductInfoDTO;
import com.sbx.app.product.params.ProductInfoParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品信息 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@Service
public class ProductInfoRepository {


    @DubboReference
    private IProductInfoApi iProductInfoApi;

    /**
     * 分页查询产品信息
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<ProductInfoDTO> page(ProductInfoParam param){
        return iProductInfoApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取产品信息
     * @param id    用户ID
     * @return      返回产品信息
     */
    public ProductInfoDTO detail(Long id){
        return iProductInfoApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建产品信息
     * @param productInfoDTO  产品信息
     * @return              返回创建数据id
     */
    public Long create(ProductInfoDTO productInfoDTO){
        return iProductInfoApi.create(productInfoDTO).computeDataOrFailThrow();
    }

    /**
     * 修改产品信息
     * @param productInfoDTO  产品信息
     * @return              返回修改结果
     */
    public Boolean update(ProductInfoDTO productInfoDTO) {
        return iProductInfoApi.update(productInfoDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除产品信息
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iProductInfoApi.delById(id).computeDataOrFailThrow();
    }

}