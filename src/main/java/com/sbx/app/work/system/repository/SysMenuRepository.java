package com.sbx.app.work.system.repository;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sbx.app.system.api.ISysAuthoritiesApi;
import com.sbx.app.system.api.ISysMenuApi;
import com.sbx.app.system.dto.SysAuthoritiesDTO;
import com.sbx.app.system.dto.SysMenuDTO;
import com.sbx.app.system.enums.AscriptionEnum;
import com.sbx.app.system.params.ChangeSortParam;
import com.sbx.app.system.params.SaveMenuAuthorityParam;
import com.sbx.app.system.params.SysAuthoritiesParam;
import com.sbx.app.system.params.SysMenuParam;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.model.exception.CustomException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class SysMenuRepository {


    @DubboReference
    private ISysMenuApi iSysMenuApi;
    @DubboReference
    private ISysAuthoritiesApi iSysAuthoritiesApi;

    /**
     * 分页查询系统菜单
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<SysMenuDTO> page(SysMenuParam param){
        return iSysMenuApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 条件获取菜单列表
     * @param param 查询条件
     * @return      返回菜单列表
     */
    public List<SysMenuDTO> listMenu(SysMenuParam param){
        List<SysMenuDTO> sysMenuList = Lists.newArrayList();
        long size = 200L;
        long current = 1L;
        param.setSize(size);
        boolean flag = true;
        do {
            param.setCurrent(current);
            PageResult<SysMenuDTO> pageResult = this.page(param);
            // 为空不需要更新，跳出循环;不为空则更新
            if (CollectionUtils.isEmpty(pageResult.getRecords())) {
                flag = false;
            } else {
                sysMenuList.addAll(pageResult.getRecords());
                // 查询数量不等于分页数量即为最后一页，跳出循环
                if (size != pageResult.getRecords().size()) {
                    flag = false;
                }
            }
            current++;
            // 循环次数大于50退出循环，实际总数最多10W左右
        } while (flag && current < 50);
        return sysMenuList;
    }

    /**
     * 根据归属获取菜单列表
     * @param ascription    菜单归属
     * @return              返回菜单列表
     */
    public List<SysMenuDTO> listMenuByAscription(Integer ascription){
        SysMenuParam param = new SysMenuParam();
        param.setAscription(ascription);
        return this.listMenu(param);
    }

    /**
     * 根据ID获取系统菜单
     * @param id    用户ID
     * @return      返回系统菜单
     */
    public SysMenuDTO detail(Long id){
        return iSysMenuApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建系统菜单
     * @param sysMenuDTO  系统菜单
     * @return              返回创建数据id
     */
    public Long create(SysMenuDTO sysMenuDTO){
        return iSysMenuApi.create(sysMenuDTO).computeDataOrFailThrow();
    }

    /**
     * 修改系统菜单
     * @param sysMenuDTO  系统菜单
     * @return              返回修改结果
     */
    public Boolean update(SysMenuDTO sysMenuDTO) {
        return iSysMenuApi.update(sysMenuDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除系统菜单
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iSysMenuApi.delById(id).computeDataOrFailThrow();
    }

    /**
     * 变更排序值
     * @param param 请求参数
     * @return  返回结果
     */
    public Boolean changeSort(ChangeSortParam param){
        return iSysMenuApi.changeSort(param).computeDataOrFailThrow();
    }

    /**
     * 批量创建菜单权限
     * @param param 创建参数
     * @return                      返回创建结果
     */
    public Boolean batchCreateAuthority(SaveMenuAuthorityParam param){
        return iSysAuthoritiesApi.batchCreate(param).computeDataOrFailThrow();
    }

    /**
     * 获取菜单权限
     * @param menuId    菜单id
     * @return          返回菜单角色列表
     */
    public List<SysAuthoritiesDTO> menuAuthorities(Long menuId){
        SysAuthoritiesParam param = new SysAuthoritiesParam();
        param.setMenuId(menuId);
        param.setCurrent(1L);
        param.setSize(200L);
        return iSysAuthoritiesApi.queryByCondition(param).computeDataOrFailThrow().getRecords();
    }

    /**
     * 获取路由信息
     * @param router
     * @return
     */
    public SysMenuDTO queryByRouter(String router){
        SysMenuParam param = new SysMenuParam();
        param.setRouter(router);
        param.setAscription(AscriptionEnum.WORK.getCode());
        return iSysMenuApi.queryByRouter(param).computeDataOrFailThrow();
    }
}