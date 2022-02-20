package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelRouteApi;
import com.sbx.app.travel.dto.TravelRouteDTO;
import com.sbx.app.travel.params.TravelRouteParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 旅行线路 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelRouteRepository {


    @DubboReference
    private ITravelRouteApi iTravelRouteApi;

    /**
     * 分页查询旅行线路
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelRouteDTO> page(TravelRouteParam param){
        return iTravelRouteApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取旅行线路
     * @param id    用户ID
     * @return      返回旅行线路
     */
    public TravelRouteDTO detail(Long id){
        return iTravelRouteApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建旅行线路
     * @param travelRouteDTO  旅行线路
     * @return              返回创建数据id
     */
    public Long create(TravelRouteDTO travelRouteDTO){
        return iTravelRouteApi.create(travelRouteDTO).computeDataOrFailThrow();
    }

    /**
     * 修改旅行线路
     * @param travelRouteDTO  旅行线路
     * @return              返回修改结果
     */
    public Boolean update(TravelRouteDTO travelRouteDTO) {
        return iTravelRouteApi.update(travelRouteDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除旅行线路
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelRouteApi.delById(id).computeDataOrFailThrow();
    }

}