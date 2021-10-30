package com.sbx.app.work.common;

import com.alibaba.fastjson.JSONObject;
import com.sbx.app.log.dto.LogDTO;
import com.sbx.app.system.enums.AscriptionEnum;
import com.sbx.app.work.log.repository.LogRepository;
import com.sbx.common.header.HeadName;
import com.sbx.core.redis.client.RedisScriptManager;
import com.sbx.core.tool.util.WebUtil;
import com.sbx.core.web.log.AbstractLogExecute;
import com.sbx.core.web.log.annotation.Log;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/2/4
 */
@Component
@RefreshScope
public class LogExecute extends AbstractLogExecute {


    @Resource
    private RedisScriptManager redisScriptManager;
    @Resource
    private LogRepository logRepository;

    @SneakyThrows
    @Override
    public void prefilter(ProceedingJoinPoint point, ApiOperation apiOperation) {
        HttpServletRequest request = WebUtil.getRequest();
        if ("GET".equals(request.getMethod())) {
            return;
        }
        //获取类名
        String className = point.getTarget().getClass().getName();
        //获取方法
        String methodName = point.getSignature().getName();
        String token = request.getHeader(HeadName.TOKEN);
        if (StringUtils.isNotBlank(token)) {
            redisScriptManager.ipAccessCount("submission:"+token+":"+className+":"+methodName,WebUtil.getRemoteIP(),1,2,1,2);
        }
    }

    @SneakyThrows
    @Override
    public void logExecute(ProceedingJoinPoint point, Object result,ApiOperation apiOperation,Log log, Long aLong) {
        HttpServletRequest request = WebUtil.getRequest();
        if ("GET".equals(request.getMethod()) && log == null) {
            return;
        }
        //获取类名
        String className = point.getTarget().getClass().getName();
        //获取方法
        String methodName = point.getSignature().getName();

        Object[] args = point.getArgs();
        List<Object> params = Lists.newArrayList();
        for(int i = 0; i < args.length; i++) {
            Object o = args[i];
            boolean isParam = (o instanceof Serializable || o instanceof BeanMap) && !(o instanceof MultipartFile);
            if (isParam) {
                params.add(o);
            }
        }
        LogDTO logDTO = new LogDTO();
        logDTO.setLogTitle(apiOperation.value());
        logDTO.setLogType(0);
        if (Objects.nonNull(log)) {
            logDTO.setLogType(log.logType());
            logDTO.setLogTitle(log.value());
        }
        Map<String,Object> content = Maps.newHashMap();
        content.put("接口描述",apiOperation.value());
        content.put("请求结果",result);
        logDTO.setContent(JSONObject.toJSONString(content));
        logDTO.setMethod(request.getMethod());
        logDTO.setMethodClass(className);
        logDTO.setMethodName(methodName);
        logDTO.setUserId(WorkContext.getUserId(false));
        logDTO.setRemoteIp(WebUtil.getRemoteIP());
        logDTO.setRequestUri(request.getRequestURI());
        logDTO.setParams(JSONObject.toJSONString(params));
        logRepository.create(logDTO);
    }
}
