package com.sbx.app.work.common;

import com.sbx.app.user.dto.UserInfoDTO;
import com.sbx.app.work.user.repository.UserInfoRepository;
import com.sbx.common.header.HeadName;
import com.sbx.core.model.context.AppContext;
import com.sbx.core.model.exception.AuthorityException;
import com.sbx.core.model.exception.SecurityException;
import com.sbx.core.web.auth.AbstractAuthExecute;
import com.sbx.core.web.auth.AuthProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2020/12/29
 */
@Component
@RefreshScope
public class AuthExecute extends AbstractAuthExecute {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private AuthProperties authProperties;

    @Value("${auth.enable-token-check:true}")
    private Boolean enableTokenCheck;

    @Value("${auth.enable-authority-check:true}")
    private Boolean enableAuthorityCheck;

    @Override
    public void authHandler(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) {
        WorkContext context = WorkContext.getContext();
        String checkUrl = request.getRequestURI();
        boolean skip = authProperties.getSkipUrl().stream().anyMatch(skipUrl -> checkUrl.matches(skipUrl.replace("*","(.*)")));

        //获取token令牌，若能拿到则查询用户信息
        String token = request.getHeader(HeadName.TOKEN);
        if (Objects.nonNull(token)) {
            context.setToken(token);
            UserInfoDTO user = userInfoRepository.userByToken(token);
            if(user != null) {
                context.setUserId(user.getId());
                context.setUser(user);
            }
        }
        if (!skip && enableTokenCheck) {
            if (StringUtils.isBlank(token)) {
                throw new SecurityException("用户未登录");
            }
            boolean skipAuthority = authProperties.getSkipAuthorityUrl().stream().anyMatch(skipUrl -> checkUrl.matches(skipUrl.replace("*","(.*)")));
            if (!skipAuthority && enableAuthorityCheck) {
                String originalUrl = request.getHeader(HeadName.X_ORIGINAL_URL);
                if (StringUtils.isBlank(originalUrl)) {
                    originalUrl = checkUrl;
                }
                if (!userInfoRepository.checkAuthority(WorkContext.getUserId(),originalUrl,request.getMethod())) {
                    throw new AuthorityException("权限不足");
                }
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        WorkContext.removeContext();
        AppContext.removeContext();
    }

}
