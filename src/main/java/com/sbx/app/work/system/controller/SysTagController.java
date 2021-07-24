package com.sbx.app.work.system.controller;


import com.sbx.app.system.dto.SysTagDTO;
import com.sbx.app.system.params.SysTagParam;
import com.sbx.app.work.system.repository.SysTagRepository;
import com.sbx.app.work.system.request.SysTagRequest;
import com.sbx.app.work.system.vo.SysTagVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统标签 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-16
 */
@RestController
@Api(tags = "系统标签接口")
@RequestMapping("/system/sys-tag")
public class SysTagController {

    @Resource
    private SysTagRepository sysTagRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询系统标签列表",notes = "分页查询系统标签列表")
    public Response<PageResult<SysTagVO>> page(SysTagRequest request){
        SysTagParam param = ObjectUtils.copy(request,SysTagParam.class);
        PageResult<SysTagDTO> dtoPageResult = sysTagRepository.page(param);
        PageResult<SysTagVO> pageResult = ObjectUtils.copyPage(dtoPageResult,SysTagVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询系统标签详情",notes = "查询系统标签详情")
    public Response<SysTagVO> detail(@PathVariable Long id){
        SysTagDTO sysTagDTO = sysTagRepository.detail(id);
        SysTagVO sysTagVO = ObjectUtils.copy(sysTagDTO,SysTagVO.class);
        return Response.data(sysTagVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加系统标签",notes = "添加系统标签")
    public Response<Long> create(@RequestBody SysTagRequest request){
        SysTagDTO sysTagDTO = ObjectUtils.copy(request,SysTagDTO.class);
        return Response.data(sysTagRepository.create(sysTagDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改系统标签",notes = "修改系统标签")
    public Response<Boolean> update(@RequestBody SysTagRequest request){
        SysTagDTO sysTagDTO = ObjectUtils.copy(request,SysTagDTO.class);
        return Response.data(sysTagRepository.update(sysTagDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除系统标签",notes = "根据id删除系统标签")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(sysTagRepository.delById(id));
    }

}
