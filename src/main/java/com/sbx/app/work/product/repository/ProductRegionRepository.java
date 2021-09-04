package com.sbx.app.work.product.repository;

import com.sbx.app.product.api.IProductRegionApi;
import com.sbx.app.product.dto.ProductRegionDTO;
import com.sbx.app.product.params.ProductRegionParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区域信息 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@Service
public class ProductRegionRepository {


    @DubboReference
    private IProductRegionApi iProductRegionApi;

    /**
     * 分页查询区域信息
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<ProductRegionDTO> page(ProductRegionParam param){
        return iProductRegionApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取区域信息
     * @param id    用户ID
     * @return      返回区域信息
     */
    public ProductRegionDTO detail(Long id){
        return iProductRegionApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建区域信息
     * @param productRegionDTO  区域信息
     * @return              返回创建数据id
     */
    public Long create(ProductRegionDTO productRegionDTO){
        return iProductRegionApi.create(productRegionDTO).computeDataOrFailThrow();
    }

    /**
     * 修改区域信息
     * @param productRegionDTO  区域信息
     * @return              返回修改结果
     */
    public Boolean update(ProductRegionDTO productRegionDTO) {
        return iProductRegionApi.update(productRegionDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除区域信息
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iProductRegionApi.delById(id).computeDataOrFailThrow();
    }

}