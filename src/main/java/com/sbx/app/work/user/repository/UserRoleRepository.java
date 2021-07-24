package com.sbx.app.work.user.repository;

import com.sbx.app.user.api.IUserRoleApi;
import com.sbx.app.user.dto.UserRoleDTO;
import com.sbx.app.user.params.UserRoleParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class UserRoleRepository {


    @DubboReference
    private IUserRoleApi iUserRoleApi;

    /**
     * 分页查询用户角色关联表
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<UserRoleDTO> page(UserRoleParam param){
        return iUserRoleApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取用户角色关联表
     * @param id    用户ID
     * @return      返回用户角色关联表
     */
    public UserRoleDTO detail(Long id){
        return iUserRoleApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建用户角色关联表
     * @param userRoleDTO  用户角色关联表
     * @return              返回创建数据id
     */
    public Long create(UserRoleDTO userRoleDTO){
        return iUserRoleApi.create(userRoleDTO).computeDataOrFailThrow();
    }

    /**
     * 修改用户角色关联表
     * @param userRoleDTO  用户角色关联表
     * @return              返回修改结果
     */
    public Boolean update(UserRoleDTO userRoleDTO) {
        return iUserRoleApi.update(userRoleDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除用户角色关联表
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iUserRoleApi.delById(id).computeDataOrFailThrow();
    }

}