package com.sbx.app.work.system.controller;


import com.sbx.app.system.dto.SysRoleDTO;
import com.sbx.app.system.params.SysRoleParam;
import com.sbx.app.work.system.repository.SysRoleRepository;
import com.sbx.app.work.system.request.SaveRoleRequest;
import com.sbx.app.work.system.request.SysRoleRequest;
import com.sbx.app.work.system.vo.SysRoleVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统角色 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "系统角色接口")
@RequestMapping("/system/role")
public class SysRoleController {

    @Resource
    private SysRoleRepository sysRoleRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询系统角色列表",notes = "分页查询系统角色列表")
    public Response<PageResult<SysRoleVO>> page(SysRoleRequest request){
        SysRoleParam param = ObjectUtils.copy(request,SysRoleParam.class);
        PageResult<SysRoleDTO> dtoPageResult = sysRoleRepository.page(param);
        PageResult<SysRoleVO> pageResult = ObjectUtils.copyPage(dtoPageResult,SysRoleVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询系统角色详情",notes = "查询系统角色详情")
    public Response<SysRoleVO> detail(@PathVariable Long id){
        SysRoleDTO sysRoleDTO = sysRoleRepository.detail(id);
        SysRoleVO sysRoleVO = ObjectUtils.copy(sysRoleDTO,SysRoleVO.class);
        return Response.data(sysRoleVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加系统角色",notes = "添加系统角色")
    public Response<Long> create(@RequestBody SaveRoleRequest request){
        SysRoleDTO sysRoleDTO = ObjectUtils.copy(request,SysRoleDTO.class);
        return Response.data(sysRoleRepository.create(sysRoleDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改系统角色",notes = "修改系统角色")
    public Response<Boolean> update(@RequestBody SaveRoleRequest request){
        SysRoleDTO sysRoleDTO = ObjectUtils.copy(request,SysRoleDTO.class);
        return Response.data(sysRoleRepository.update(sysRoleDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除系统角色",notes = "根据id删除系统角色")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(sysRoleRepository.delById(id));
    }

}
