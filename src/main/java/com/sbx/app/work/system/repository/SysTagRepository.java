package com.sbx.app.work.system.repository;

import com.sbx.app.system.api.ISysTagApi;
import com.sbx.app.system.dto.SysTagDTO;
import com.sbx.app.system.params.SysTagParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统标签 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-16
 */
@Service
public class SysTagRepository {


    @DubboReference
    private ISysTagApi iSysTagApi;

    /**
     * 分页查询系统标签
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<SysTagDTO> page(SysTagParam param){
        return iSysTagApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取系统标签
     * @param id    用户ID
     * @return      返回系统标签
     */
    public SysTagDTO detail(Long id){
        return iSysTagApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建系统标签
     * @param sysTagDTO  系统标签
     * @return              返回创建数据id
     */
    public Long create(SysTagDTO sysTagDTO){
        return iSysTagApi.create(sysTagDTO).computeDataOrFailThrow();
    }

    /**
     * 修改系统标签
     * @param sysTagDTO  系统标签
     * @return              返回修改结果
     */
    public Boolean update(SysTagDTO sysTagDTO) {
        return iSysTagApi.update(sysTagDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除系统标签
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iSysTagApi.delById(id).computeDataOrFailThrow();
    }

}