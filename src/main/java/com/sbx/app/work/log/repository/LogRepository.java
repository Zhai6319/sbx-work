package com.sbx.app.work.log.repository;

import com.sbx.app.log.api.ILogApi;
import com.sbx.app.log.dto.LogDTO;
import com.sbx.app.log.params.LogParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志记录 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2021-10-29
 */
@Service
public class LogRepository {


    @DubboReference
    private ILogApi iLogApi;

    /**
     * 分页查询日志记录
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<LogDTO> page(LogParam param){
        return iLogApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取日志记录
     * @param id    用户ID
     * @return      返回日志记录
     */
    public LogDTO detail(Long id){
        return iLogApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建日志记录
     * @param logDTO  日志记录
     * @return              返回创建数据id
     */
    public Long create(LogDTO logDTO){
        return iLogApi.create(logDTO).computeDataOrFailThrow();
    }

    /**
     * 修改日志记录
     * @param logDTO  日志记录
     * @return              返回修改结果
     */
    public Boolean update(LogDTO logDTO) {
        return iLogApi.update(logDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除日志记录
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iLogApi.delById(id).computeDataOrFailThrow();
    }

}