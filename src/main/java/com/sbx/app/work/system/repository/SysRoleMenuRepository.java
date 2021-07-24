package com.sbx.app.work.system.repository;

import com.sbx.app.system.api.ISysRoleMenuApi;
import com.sbx.app.system.dto.SysRoleMenuDTO;
import com.sbx.app.system.params.SysRoleMenuParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单表 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class SysRoleMenuRepository {


    @DubboReference
    private ISysRoleMenuApi iSysRoleMenuApi;

    /**
     * 分页查询角色菜单表
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<SysRoleMenuDTO> page(SysRoleMenuParam param){
        return iSysRoleMenuApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取角色菜单表
     * @param id    用户ID
     * @return      返回角色菜单表
     */
    public SysRoleMenuDTO detail(Long id){
        return iSysRoleMenuApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建角色菜单表
     * @param sysRoleMenuDTO  角色菜单表
     * @return              返回创建数据id
     */
    public Long create(SysRoleMenuDTO sysRoleMenuDTO){
        return iSysRoleMenuApi.create(sysRoleMenuDTO).computeDataOrFailThrow();
    }

    /**
     * 修改角色菜单表
     * @param sysRoleMenuDTO  角色菜单表
     * @return              返回修改结果
     */
    public Boolean update(SysRoleMenuDTO sysRoleMenuDTO) {
        return iSysRoleMenuApi.update(sysRoleMenuDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除角色菜单表
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iSysRoleMenuApi.delById(id).computeDataOrFailThrow();
    }

}