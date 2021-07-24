package com.sbx.app.work.system.controller;


import com.sbx.app.system.dto.SysRoleMenuDTO;
import com.sbx.app.system.params.SysRoleMenuParam;
import com.sbx.app.work.system.repository.SysRoleMenuRepository;
import com.sbx.app.work.system.request.SysRoleMenuRequest;
import com.sbx.app.work.system.vo.SysRoleMenuVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 角色菜单表 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "角色菜单表接口")
@RequestMapping("/system/sys-role-menu")
public class SysRoleMenuController {

    @Resource
    private SysRoleMenuRepository sysRoleMenuRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询角色菜单表列表",notes = "分页查询角色菜单表列表")
    public Response<PageResult<SysRoleMenuVO>> page(SysRoleMenuRequest request){
        SysRoleMenuParam param = ObjectUtils.copy(request,SysRoleMenuParam.class);
        PageResult<SysRoleMenuDTO> dtoPageResult = sysRoleMenuRepository.page(param);
        PageResult<SysRoleMenuVO> pageResult = ObjectUtils.copyPage(dtoPageResult,SysRoleMenuVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询角色菜单表详情",notes = "查询角色菜单表详情")
    public Response<SysRoleMenuVO> detail(@PathVariable Long id){
        SysRoleMenuDTO sysRoleMenuDTO = sysRoleMenuRepository.detail(id);
        SysRoleMenuVO sysRoleMenuVO = ObjectUtils.copy(sysRoleMenuDTO,SysRoleMenuVO.class);
        return Response.data(sysRoleMenuVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加角色菜单表",notes = "添加角色菜单表")
    public Response<Long> create(@RequestBody SysRoleMenuRequest request){
        SysRoleMenuDTO sysRoleMenuDTO = ObjectUtils.copy(request,SysRoleMenuDTO.class);
        return Response.data(sysRoleMenuRepository.create(sysRoleMenuDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改角色菜单表",notes = "修改角色菜单表")
    public Response<Boolean> update(@RequestBody SysRoleMenuRequest request){
        SysRoleMenuDTO sysRoleMenuDTO = ObjectUtils.copy(request,SysRoleMenuDTO.class);
        return Response.data(sysRoleMenuRepository.update(sysRoleMenuDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除角色菜单表",notes = "根据id删除角色菜单表")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(sysRoleMenuRepository.delById(id));
    }

}
