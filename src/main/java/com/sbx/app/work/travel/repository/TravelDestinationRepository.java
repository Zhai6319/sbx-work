package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelDestinationApi;
import com.sbx.app.travel.dto.TravelDestinationDTO;
import com.sbx.app.travel.params.TravelDestinationParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区域目的地 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelDestinationRepository {


    @DubboReference
    private ITravelDestinationApi iTravelDestinationApi;

    /**
     * 分页查询区域目的地
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelDestinationDTO> page(TravelDestinationParam param){
        return iTravelDestinationApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取区域目的地
     * @param id    用户ID
     * @return      返回区域目的地
     */
    public TravelDestinationDTO detail(Long id){
        return iTravelDestinationApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建区域目的地
     * @param travelDestinationDTO  区域目的地
     * @return              返回创建数据id
     */
    public Long create(TravelDestinationDTO travelDestinationDTO){
        return iTravelDestinationApi.create(travelDestinationDTO).computeDataOrFailThrow();
    }

    /**
     * 修改区域目的地
     * @param travelDestinationDTO  区域目的地
     * @return              返回修改结果
     */
    public Boolean update(TravelDestinationDTO travelDestinationDTO) {
        return iTravelDestinationApi.update(travelDestinationDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除区域目的地
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelDestinationApi.delById(id).computeDataOrFailThrow();
    }

}