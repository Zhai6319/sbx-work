package com.sbx.app.work.system.repository;

import com.google.common.collect.Lists;
import com.sbx.app.system.api.ISysRoleApi;
import com.sbx.app.system.dto.SysMenuDTO;
import com.sbx.app.system.dto.SysRoleDTO;
import com.sbx.app.system.enums.AscriptionEnum;
import com.sbx.app.system.params.SysMenuParam;
import com.sbx.app.system.params.SysRoleParam;
import com.sbx.core.model.base.dto.BaseDTO;
import com.sbx.core.model.base.result.PageResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统角色 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class SysRoleRepository {


    @DubboReference
    private ISysRoleApi iSysRoleApi;

    /**
     * 分页查询系统角色
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<SysRoleDTO> page(SysRoleParam param){
        param.setRoleType(AscriptionEnum.WORK.getCode());
        return iSysRoleApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 条件获取菜单列表
     * @param param 查询条件
     * @return      返回菜单列表
     */
    public List<SysRoleDTO> listRole(SysRoleParam param){
        List<SysRoleDTO> allResultList = Lists.newArrayList();
        long size = 200L;
        long current = 1L;
        param.setSize(size);
        boolean flag = true;
        do {
            param.setCurrent(current);
            PageResult<SysRoleDTO> pageResult = this.page(param);
            // 为空不需要更新，跳出循环;不为空则更新
            if (CollectionUtils.isEmpty(pageResult.getRecords())) {
                flag = false;
            } else {
                allResultList.addAll(pageResult.getRecords());
                // 查询数量不等于分页数量即为最后一页，跳出循环
                if (size != pageResult.getRecords().size()) {
                    flag = false;
                }
            }
            current++;
            // 循环次数大于50退出循环，实际总数最多10W左右
        } while (flag && current < 50);
        return allResultList;
    }

    /**
     * 根据ID获取系统角色
     * @param id    用户ID
     * @return      返回系统角色
     */
    public SysRoleDTO detail(Long id){
        return iSysRoleApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建系统角色
     * @param sysRoleDTO  系统角色
     * @return              返回创建数据id
     */
    public Long create(SysRoleDTO sysRoleDTO){
        return iSysRoleApi.create(sysRoleDTO).computeDataOrFailThrow();
    }

    /**
     * 修改系统角色
     * @param sysRoleDTO  系统角色
     * @return              返回修改结果
     */
    public Boolean update(SysRoleDTO sysRoleDTO) {
        return iSysRoleApi.update(sysRoleDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除系统角色
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iSysRoleApi.delById(id).computeDataOrFailThrow();
    }

    /**
     * 根据角色id列表获取角色列表
     * @param sysRoleIds    角色id列表
     * @return  返回角色列表
     */
    public List<SysRoleDTO> listByRoleIds(List<Long> sysRoleIds) {
        if (CollectionUtils.isEmpty(sysRoleIds)) {
            return Collections.emptyList();
        }
        SysRoleParam param = new SysRoleParam();
        param.setIds(sysRoleIds);
        return this.listRole(param);
    }

    /**
     * 根据角色id列表获取角色map
     * @param sysRoleIds    角色id列表
     * @return  返回map
     */
    public Map<Long, SysRoleDTO> mapByRoleIds(List<Long> sysRoleIds){
        if (CollectionUtils.isEmpty(sysRoleIds)) {
            return Collections.emptyMap();
        }
        List<SysRoleDTO> roles = this.listByRoleIds(sysRoleIds);
        return roles.stream().collect(Collectors.toMap(BaseDTO::getId, Function.identity()));
    }
}