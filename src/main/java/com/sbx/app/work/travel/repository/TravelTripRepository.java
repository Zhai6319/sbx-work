package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelTripApi;
import com.sbx.app.travel.dto.TravelTripDTO;
import com.sbx.app.travel.params.TravelTripParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日行程介绍 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelTripRepository {


    @DubboReference
    private ITravelTripApi iTravelTripApi;

    /**
     * 分页查询每日行程介绍
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelTripDTO> page(TravelTripParam param){
        return iTravelTripApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取每日行程介绍
     * @param id    用户ID
     * @return      返回每日行程介绍
     */
    public TravelTripDTO detail(Long id){
        return iTravelTripApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建每日行程介绍
     * @param travelTripDTO  每日行程介绍
     * @return              返回创建数据id
     */
    public Long create(TravelTripDTO travelTripDTO){
        return iTravelTripApi.create(travelTripDTO).computeDataOrFailThrow();
    }

    /**
     * 修改每日行程介绍
     * @param travelTripDTO  每日行程介绍
     * @return              返回修改结果
     */
    public Boolean update(TravelTripDTO travelTripDTO) {
        return iTravelTripApi.update(travelTripDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除每日行程介绍
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelTripApi.delById(id).computeDataOrFailThrow();
    }

}