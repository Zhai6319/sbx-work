package com.sbx.app.work.log.service.impl;

import com.sbx.app.log.dto.LogDTO;
import com.sbx.app.log.params.LogParam;
import com.sbx.app.user.dto.UserInfoDTO;
import com.sbx.app.user.enums.UserTypeEnum;
import com.sbx.app.work.log.repository.LogRepository;
import com.sbx.app.work.log.request.LogRequest;
import com.sbx.app.work.log.service.ILogService;
import com.sbx.app.work.log.vo.LogVO;
import com.sbx.app.work.user.repository.UserInfoRepository;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/10/30
 */
@Service
public class LogServiceImpl implements ILogService {

    @Resource
    private LogRepository logRepository;
    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public PageResult<LogVO> pageVO(LogRequest request) {
        LogParam param = ObjectUtils.copy(request,LogParam.class);
        PageResult<LogDTO> dtoPageResult = logRepository.page(param);
        List<Long> userIds = dtoPageResult.getRecords().stream().map(LogDTO::getUserId).collect(Collectors.toList());
        Map<Long, UserInfoDTO> userMap = userInfoRepository.mapByIds(userIds);
        return ObjectUtils.copyPage(dtoPageResult,LogVO.class,((logDTO, logVO) -> {
            UserInfoDTO user = userMap.get(logDTO.getUserId());
            if (Objects.nonNull(user)) {
                logVO.setUsername(user.getUsername());
                logVO.setUserTypeName(UserTypeEnum.findByType(user.getUserType()).getDesc());
            }
        }));
    }
}
