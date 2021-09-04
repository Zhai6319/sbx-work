package com.sbx.app.work.product.repository;

import com.sbx.app.product.api.IProductRegionDestinationApi;
import com.sbx.app.product.dto.ProductRegionDestinationDTO;
import com.sbx.app.product.params.ProductRegionDestinationParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区域目的地 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@Service
public class ProductRegionDestinationRepository {


    @DubboReference
    private IProductRegionDestinationApi iProductRegionDestinationApi;

    /**
     * 分页查询区域目的地
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<ProductRegionDestinationDTO> page(ProductRegionDestinationParam param){
        return iProductRegionDestinationApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取区域目的地
     * @param id    用户ID
     * @return      返回区域目的地
     */
    public ProductRegionDestinationDTO detail(Long id){
        return iProductRegionDestinationApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建区域目的地
     * @param productRegionDestinationDTO  区域目的地
     * @return              返回创建数据id
     */
    public Long create(ProductRegionDestinationDTO productRegionDestinationDTO){
        return iProductRegionDestinationApi.create(productRegionDestinationDTO).computeDataOrFailThrow();
    }

    /**
     * 修改区域目的地
     * @param productRegionDestinationDTO  区域目的地
     * @return              返回修改结果
     */
    public Boolean update(ProductRegionDestinationDTO productRegionDestinationDTO) {
        return iProductRegionDestinationApi.update(productRegionDestinationDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除区域目的地
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iProductRegionDestinationApi.delById(id).computeDataOrFailThrow();
    }

}