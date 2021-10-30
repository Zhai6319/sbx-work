package com.sbx.app.work.log.controller;


import com.sbx.app.log.dto.LogDTO;
import com.sbx.app.log.params.LogParam;
import com.sbx.app.work.log.repository.LogRepository;
import com.sbx.app.work.log.request.LogRequest;
import com.sbx.app.work.log.service.ILogService;
import com.sbx.app.work.log.vo.LogVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 日志记录 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-10-29
 */
@RestController
@Api(tags = "日志记录接口")
@RequestMapping("/log/log")
public class LogController {

    @Resource
    private LogRepository logRepository;
    @Resource
    private ILogService iLogService;

    @GetMapping("")
    @ApiOperation(value = "分页查询日志记录列表",notes = "分页查询日志记录列表")
    public Response<PageResult<LogVO>> page(LogRequest request){
        return Response.data(iLogService.pageVO(request));
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询日志记录详情",notes = "查询日志记录详情")
    public Response<LogVO> detail(@PathVariable Long id){
        LogDTO logDTO = logRepository.detail(id);
        LogVO logVO = ObjectUtils.copy(logDTO,LogVO.class);
        return Response.data(logVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加日志记录",notes = "添加日志记录")
    public Response<Long> create(@RequestBody LogRequest request){
        LogDTO logDTO = ObjectUtils.copy(request,LogDTO.class);
        return Response.data(logRepository.create(logDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改日志记录",notes = "修改日志记录")
    public Response<Boolean> update(@RequestBody LogRequest request){
        LogDTO logDTO = ObjectUtils.copy(request,LogDTO.class);
        return Response.data(logRepository.update(logDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除日志记录",notes = "根据id删除日志记录")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(logRepository.delById(id));
    }

}
