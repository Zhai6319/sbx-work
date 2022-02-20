package com.sbx.app.work.travel.repository;

import com.sbx.app.travel.api.ITravelDeclareApi;
import com.sbx.app.travel.dto.TravelDeclareDTO;
import com.sbx.app.travel.params.TravelDeclareParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 旅行声明 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@Service
public class TravelDeclareRepository {


    @DubboReference
    private ITravelDeclareApi iTravelDeclareApi;

    /**
     * 分页查询旅行声明
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<TravelDeclareDTO> page(TravelDeclareParam param){
        return iTravelDeclareApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取旅行声明
     * @param id    用户ID
     * @return      返回旅行声明
     */
    public TravelDeclareDTO detail(Long id){
        return iTravelDeclareApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建旅行声明
     * @param travelDeclareDTO  旅行声明
     * @return              返回创建数据id
     */
    public Long create(TravelDeclareDTO travelDeclareDTO){
        return iTravelDeclareApi.create(travelDeclareDTO).computeDataOrFailThrow();
    }

    /**
     * 修改旅行声明
     * @param travelDeclareDTO  旅行声明
     * @return              返回修改结果
     */
    public Boolean update(TravelDeclareDTO travelDeclareDTO) {
        return iTravelDeclareApi.update(travelDeclareDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除旅行声明
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iTravelDeclareApi.delById(id).computeDataOrFailThrow();
    }

}