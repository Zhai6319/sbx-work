package com.sbx.app.work.log.service;

import com.sbx.app.work.log.request.LogRequest;
import com.sbx.app.work.log.vo.LogVO;
import com.sbx.core.model.base.result.PageResult;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/10/30
 */
public interface ILogService {

    /**
     * 分页查询
     * @param request   请求参数
     * @return  返回结果
     */
    PageResult<LogVO> pageVO(LogRequest request);
}
