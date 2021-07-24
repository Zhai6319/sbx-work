package com.sbx.app.work.user.service.impl;

import com.google.common.collect.Lists;
import com.sbx.app.system.dto.SysRoleDTO;
import com.sbx.app.user.dto.UserInfoDetailDTO;
import com.sbx.app.user.enums.UserSourceEnum;
import com.sbx.app.user.params.UserInfoParam;
import com.sbx.app.work.system.repository.SysRoleRepository;
import com.sbx.app.work.system.vo.SysRoleVO;
import com.sbx.app.work.user.repository.UserInfoRepository;
import com.sbx.app.work.user.request.UserInfoQueryRequest;
import com.sbx.app.work.user.service.IUserService;
import com.sbx.app.work.user.vo.UserInfoVO;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.CollectionUtil;
import com.sbx.core.tool.util.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/9
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private SysRoleRepository sysRoleRepository;


    @Override
    public PageResult<UserInfoVO> userPage(UserInfoQueryRequest request) {

        UserInfoParam param = ObjectUtils.copy(request,UserInfoParam.class);
        PageResult<UserInfoDetailDTO> dtoPageResult = userInfoRepository.page(param);
        List<Long> roleIds = new ArrayList<>();
        dtoPageResult.getRecords().stream().map(UserInfoDetailDTO::getRoleIds).forEach(tempRoleIds -> {
            if (CollectionUtil.isNotEmpty(tempRoleIds)) {
                roleIds.addAll(tempRoleIds);
            }
        });
        Map<Long, SysRoleDTO> roleMap = sysRoleRepository.mapByRoleIds(roleIds);
        return ObjectUtils.copyPage(dtoPageResult,UserInfoVO.class,(dtoPage,voPage) -> {
            voPage.setSourceName(UserSourceEnum.getByCode(dtoPage.getSource()).getDesc());
            List<SysRoleVO> roles = Lists.newArrayList();
            if (CollectionUtil.isNotEmpty(dtoPage.getRoleIds())) {
                dtoPage.getRoleIds().forEach(roleId -> roles.add(ObjectUtils.copy(roleMap.get(roleId),SysRoleVO.class)));
            }
            voPage.setRoleList(roles);
        });
    }
}
