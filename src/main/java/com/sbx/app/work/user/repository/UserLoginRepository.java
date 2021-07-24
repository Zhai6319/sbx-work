package com.sbx.app.work.user.repository;

import com.sbx.app.user.api.IUserLoginApi;
import com.sbx.app.user.dto.UserAuthDTO;
import com.sbx.app.user.dto.UserLoginDTO;
import com.sbx.app.user.params.UserAuthParam;
import com.sbx.app.user.params.UserLoginParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class UserLoginRepository {


    @DubboReference
    private IUserLoginApi iUserLoginApi;

    /**
     * 分页查询用户登录
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<UserLoginDTO> page(UserLoginParam param){
        return iUserLoginApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取用户登录
     * @param id    用户ID
     * @return      返回用户登录
     */
    public UserLoginDTO detail(Long id){
        return iUserLoginApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建用户登录
     * @param userLoginDTO  用户登录
     * @return              返回创建数据id
     */
    public Long create(UserLoginDTO userLoginDTO){
        return iUserLoginApi.create(userLoginDTO).computeDataOrFailThrow();
    }

    /**
     * 修改用户登录
     * @param userLoginDTO  用户登录
     * @return              返回修改结果
     */
    public Boolean update(UserLoginDTO userLoginDTO) {
        return iUserLoginApi.update(userLoginDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除用户登录
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iUserLoginApi.delById(id).computeDataOrFailThrow();
    }


    /**
     * 用户授权
     * @param param 请求参数
     * @return  返回授权信息
     */
    public UserAuthDTO userAuth(UserAuthParam param){
        return iUserLoginApi.userAuth(param).computeDataOrFailThrow();
    }
}