package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelGroupApi;
import com.sbx.app.travel.dto.TravelGroupDTO;
import com.sbx.app.travel.params.TravelGroupParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分组查询 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-03-07
 */
@Service
public class TravelGroupRepository {


    @DubboReference
    private ITravelGroupApi iTravelGroupApi;

    /**
     * 分页查询分组查询
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelGroupDTO> page(TravelGroupParam param){
        return iTravelGroupApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取分组查询
     * @param id    用户ID
     * @return      返回分组查询
     */
    public TravelGroupDTO detail(Long id){
        return iTravelGroupApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建分组查询
     * @param travelGroupDTO  分组查询
     * @return              返回创建数据id
     */
    public Long create(TravelGroupDTO travelGroupDTO){
        return iTravelGroupApi.create(travelGroupDTO).computeDataOrFailThrow();
    }

    /**
     * 修改分组查询
     * @param travelGroupDTO  分组查询
     * @return              返回修改结果
     */
    public Boolean update(TravelGroupDTO travelGroupDTO) {
        return iTravelGroupApi.update(travelGroupDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除分组查询
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelGroupApi.delById(id).computeDataOrFailThrow();
    }

}