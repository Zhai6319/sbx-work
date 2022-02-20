package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelRegionApi;
import com.sbx.app.travel.dto.TravelRegionDTO;
import com.sbx.app.travel.params.TravelRegionParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区域信息 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelRegionRepository {


    @DubboReference
    private ITravelRegionApi iTravelRegionApi;

    /**
     * 分页查询区域信息
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelRegionDTO> page(TravelRegionParam param){
        return iTravelRegionApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取区域信息
     * @param id    用户ID
     * @return      返回区域信息
     */
    public TravelRegionDTO detail(Long id){
        return iTravelRegionApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建区域信息
     * @param travelRegionDTO  区域信息
     * @return              返回创建数据id
     */
    public Long create(TravelRegionDTO travelRegionDTO){
        return iTravelRegionApi.create(travelRegionDTO).computeDataOrFailThrow();
    }

    /**
     * 修改区域信息
     * @param travelRegionDTO  区域信息
     * @return              返回修改结果
     */
    public Boolean update(TravelRegionDTO travelRegionDTO) {
        return iTravelRegionApi.update(travelRegionDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除区域信息
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelRegionApi.delById(id).computeDataOrFailThrow();
    }

}