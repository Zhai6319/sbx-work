package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelRouteHighlightsApi;
import com.sbx.app.travel.dto.TravelRouteHighlightsDTO;
import com.sbx.app.travel.params.TravelRouteHighlightsParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 旅游路线亮点 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelRouteHighlightsRepository {


    @DubboReference
    private ITravelRouteHighlightsApi iTravelRouteHighlightsApi;

    /**
     * 分页查询旅游路线亮点
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelRouteHighlightsDTO> page(TravelRouteHighlightsParam param){
        return iTravelRouteHighlightsApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取旅游路线亮点
     * @param id    用户ID
     * @return      返回旅游路线亮点
     */
    public TravelRouteHighlightsDTO detail(Long id){
        return iTravelRouteHighlightsApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建旅游路线亮点
     * @param travelRouteHighlightsDTO  旅游路线亮点
     * @return              返回创建数据id
     */
    public Long create(TravelRouteHighlightsDTO travelRouteHighlightsDTO){
        return iTravelRouteHighlightsApi.create(travelRouteHighlightsDTO).computeDataOrFailThrow();
    }

    /**
     * 修改旅游路线亮点
     * @param travelRouteHighlightsDTO  旅游路线亮点
     * @return              返回修改结果
     */
    public Boolean update(TravelRouteHighlightsDTO travelRouteHighlightsDTO) {
        return iTravelRouteHighlightsApi.update(travelRouteHighlightsDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除旅游路线亮点
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelRouteHighlightsApi.delById(id).computeDataOrFailThrow();
    }

}