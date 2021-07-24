package com.sbx.app.work.system.repository;

import com.sbx.app.system.api.ISysAuthoritiesApi;
import com.sbx.app.system.dto.SysAuthoritiesDTO;
import com.sbx.app.system.params.SysAuthoritiesParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统权限 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class SysAuthoritiesRepository {


    @DubboReference
    private ISysAuthoritiesApi iSysAuthoritiesApi;

    /**
     * 分页查询系统权限
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<SysAuthoritiesDTO> page(SysAuthoritiesParam param){
        return iSysAuthoritiesApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取系统权限
     * @param id    用户ID
     * @return      返回系统权限
     */
    public SysAuthoritiesDTO detail(Long id){
        return iSysAuthoritiesApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建系统权限
     * @param sysAuthoritiesDTO  系统权限
     * @return              返回创建数据id
     */
    public Long create(SysAuthoritiesDTO sysAuthoritiesDTO){
        return iSysAuthoritiesApi.create(sysAuthoritiesDTO).computeDataOrFailThrow();
    }

    /**
     * 修改系统权限
     * @param sysAuthoritiesDTO  系统权限
     * @return              返回修改结果
     */
    public Boolean update(SysAuthoritiesDTO sysAuthoritiesDTO) {
        return iSysAuthoritiesApi.update(sysAuthoritiesDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除系统权限
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iSysAuthoritiesApi.delById(id).computeDataOrFailThrow();
    }

}