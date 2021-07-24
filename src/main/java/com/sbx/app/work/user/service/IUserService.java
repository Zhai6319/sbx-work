package com.sbx.app.work.user.service;

import com.sbx.app.work.user.request.UserInfoQueryRequest;
import com.sbx.app.work.user.vo.UserInfoVO;
import com.sbx.core.model.base.result.PageResult;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/9
 */
public interface IUserService {

    /**
     * 分页查询用户信息
     * @param request   请求参数
     * @return  返回用户信息
     */
    PageResult<UserInfoVO> userPage(UserInfoQueryRequest request);
}
