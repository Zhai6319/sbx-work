package com.sbx.app.work.user.repository;

import com.google.common.collect.Lists;
import com.sbx.app.system.dto.SysMenuDTO;
import com.sbx.app.user.api.IUserInfoApi;
import com.sbx.app.user.dto.UserInfoDTO;
import com.sbx.app.user.dto.UserInfoDetailDTO;
import com.sbx.app.user.dto.UserNavigationBarDTO;
import com.sbx.app.user.enums.LoginTypeEnum;
import com.sbx.app.user.enums.UserSourceEnum;
import com.sbx.app.user.enums.UserTypeEnum;
import com.sbx.app.user.params.UserInfoParam;
import com.sbx.app.user.params.UserSaveParam;
import com.sbx.core.model.base.dto.BaseDTO;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.CollectionUtil;
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
 * 用户信息 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@Service
public class UserInfoRepository {


    @DubboReference
    private IUserInfoApi iUserInfoApi;

    /**
     * 分页查询用户信息
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<UserInfoDetailDTO> page(UserInfoParam param){
        return iUserInfoApi.queryByCondition(param).computeDataOrFailThrow();
    }

    public PageResult<UserInfoDTO> queryByCondition(UserInfoParam param){
        return iUserInfoApi.queryPageByCondition(param).computeDataOrFailThrow();
    }

    public List<UserInfoDTO> list(UserInfoParam param) {
        List<UserInfoDTO> allList = Lists.newArrayList();
        long size = 200L;
        long current = 1L;
        param.setSize(size);
        boolean flag = true;
        do {
            param.setCurrent(current);
            PageResult<UserInfoDTO> pageResult = this.queryByCondition(param);
            // 为空不需要更新，跳出循环;不为空则更新
            if (CollectionUtils.isEmpty(pageResult.getRecords())) {
                flag = false;
            } else {
                allList.addAll(pageResult.getRecords());
                // 查询数量不等于分页数量即为最后一页，跳出循环
                if (size != pageResult.getRecords().size()) {
                    flag = false;
                }
            }
            current++;
            // 循环次数大于50退出循环，实际总数最多10W左右
        } while (flag && current < 50);
        return allList;
    }

    public List<UserInfoDTO> listByIds(List<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        UserInfoParam param = new UserInfoParam();
        param.setIds(ids);
        return this.list(param);
    }

    public Map<Long, UserInfoDTO> mapByIds(List<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return Collections.emptyMap();
        }
        List<UserInfoDTO> userList = this.listByIds(ids);
        return userList.stream().collect(Collectors.toMap(BaseDTO::getId, Function.identity()));
    }

    /**
     * 根据ID获取用户信息
     * @param id    用户ID
     * @return      返回用户信息
     */
    public UserInfoDTO detail(Long id){
        return iUserInfoApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建用户信息
     * @param userInfoDTO  用户信息
     * @param password 密码
     * @return              返回创建数据id
     */
    public Long create(UserInfoDTO userInfoDTO,String password, List<Long> roleIds){

        userInfoDTO.setUserType(UserTypeEnum.ADMIN.getCode());
        userInfoDTO.setSource(UserSourceEnum.WORK_PC.getCode());

        UserSaveParam param = new UserSaveParam();
        param.setUserInfo(userInfoDTO);
        param.setPassword(password);
        param.setRoleIds(roleIds);
        param.setLoginType(LoginTypeEnum.PASSWORD.getCode());
        return iUserInfoApi.create(param).computeDataOrFailThrow();
    }

    /**
     * 修改用户信息
     * @param userInfoDTO  用户信息
     * @param roleIds 角色id列表
     * @return              返回修改结果
     */
    public Boolean update(UserInfoDTO userInfoDTO,List<Long> roleIds) {
        UserSaveParam param = new UserSaveParam();
        param.setUserInfo(userInfoDTO);
        param.setRoleIds(roleIds);
        return iUserInfoApi.update(param).computeDataOrFailThrow();
    }

    /**
     * 根据id删除用户信息
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iUserInfoApi.delById(id).computeDataOrFailThrow();
    }

    /**
     * 获取用户导航列表
     * @param userId    用户id
     * @return  返回导航列表
     */
    public List<UserNavigationBarDTO> userNavigationBarList(Long userId){
        UserInfoParam param = new UserInfoParam();
        param.setId(userId);
        return iUserInfoApi.userNavigationBarList(param).computeDataOrFailThrow();
    }

    /**
     * 根据登录令牌获取用户信息
     * @param token 登录令牌
     * @return  返回用户信息
     */
    public UserInfoDTO userByToken(String token){
        return iUserInfoApi.userByToken(token).computeDataOrFailThrow();
    }

    /**
     * 检查权限
     * @param userId 用户id
     * @param authority 权限url
     * @param method    请求方法
     * @return  返回结果
     */
    public Boolean checkAuthority(Long userId,String authority,String method){
        return iUserInfoApi.checkUserAuthority(authority,method,userId).computeDataOrFailThrow();
    }

    public UserNavigationBarDTO router(Long userId,String path){
        return iUserInfoApi.router(userId,path).computeDataOrFailThrow();
    }

    /**
     * 获取路由链
     * @param userId    用户id
     * @param path  前端路由
     * @return  返回路由链
     */
    public List<UserNavigationBarDTO> routeChain(Long userId, String path) {
        return iUserInfoApi.userRouter(userId,path).computeDataOrFailThrow();
    }
}