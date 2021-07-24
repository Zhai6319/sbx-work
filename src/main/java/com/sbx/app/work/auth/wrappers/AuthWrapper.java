package com.sbx.app.work.auth.wrappers;


import com.sbx.app.user.dto.UserNavigationBarDTO;
import com.sbx.app.work.auth.vo.*;
import com.sbx.core.tool.util.ObjectUtils;

import java.util.List;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/6/26
 */
public class AuthWrapper {

    /**
     * 数据类转换
     * @param userNavigationBarList    dto数据
     * @return              返回vo展示数据
     */
    public static List<UserNavigationBarVO> convertList(List<UserNavigationBarDTO> userNavigationBarList){
        return ObjectUtils.copyList(userNavigationBarList,UserNavigationBarVO.class,((navDTO, navTreeVO) -> {
            UserNavigationMetaVO navMetaVO = ObjectUtils.copy(navDTO.getMeta(),UserNavigationMetaVO.class,((navMetaDTO, navMeta) -> {
                navMeta.setButtons(ObjectUtils.copyList(navMetaDTO.getButtons(), UserButtonVO.class));
            }));
            navTreeVO.setMeta(navMetaVO);
        }));
    }

    /**
     * 非对象转换
     * @param router 路由信息
     * @return
     */
    public static UserNavigationBarVO convertVO(UserNavigationBarDTO router){
        return ObjectUtils.copy(router,UserNavigationBarVO.class,((navDTO, navTreeVO) -> {
            UserNavigationMetaVO navMetaVO = ObjectUtils.copy(navDTO.getMeta(),UserNavigationMetaVO.class,((navMetaDTO, navMeta) -> {
                navMeta.setButtons(ObjectUtils.copyList(navMetaDTO.getButtons(), UserButtonVO.class));
            }));
            navTreeVO.setMeta(navMetaVO);
        }));
    }
}
