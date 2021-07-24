package com.sbx.app.work.common;

import com.sbx.app.user.dto.UserInfoDTO;
import com.sbx.core.model.exception.SecurityException;


public class WorkContext {

    private Long userId;

    private String token;

    private UserInfoDTO user;

    private static final ThreadLocal<WorkContext> LOCAL = ThreadLocal.withInitial(WorkContext::new);

    public static WorkContext getContext() {
        return LOCAL.get();
    }

    public static void setContext(WorkContext context) {
        LOCAL.set(context);
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public static Long getUserId(boolean force) {
        Long userId = LOCAL.get().userId;
        if (force && userId == null) {
            throw new SecurityException("用户未登陆");
        }
        return userId;
    }

    public static Long getUserId() {
        return getUserId(true);
    }

    public static UserInfoDTO getUser(boolean force) {
        UserInfoDTO worker = LOCAL.get().user;
        if (force && worker == null) {
            throw new SecurityException("用户未登陆");
        }
        return worker;
    }

    public static UserInfoDTO getUser() {
        return getUser(true);
    }

    public void setToken(String token){
        this.token = token;
    }

    public static String getToken(){
        return LOCAL.get().token;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUser(UserInfoDTO user) {
        this.user = user;
    }
}
