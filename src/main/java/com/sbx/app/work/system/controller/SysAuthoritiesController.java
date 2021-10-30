package com.sbx.app.work.system.controller;


import com.sbx.app.system.dto.SysAuthoritiesDTO;
import com.sbx.app.system.params.SysAuthoritiesParam;
import com.sbx.app.work.system.repository.SysAuthoritiesRepository;
import com.sbx.app.work.system.request.SysAuthoritiesRequest;
import com.sbx.app.work.system.vo.SysAuthoritiesVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统权限 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "系统权限接口")
@RequestMapping("/system/authorities")
public class SysAuthoritiesController {

    @Resource
    private SysAuthoritiesRepository sysAuthoritiesRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询系统权限列表",notes = "分页查询系统权限列表")
    public Response<PageResult<SysAuthoritiesVO>> page(SysAuthoritiesRequest request){
        SysAuthoritiesParam param = ObjectUtils.copy(request,SysAuthoritiesParam.class);
        PageResult<SysAuthoritiesDTO> dtoPageResult = sysAuthoritiesRepository.page(param);
        PageResult<SysAuthoritiesVO> pageResult = ObjectUtils.copyPage(dtoPageResult,SysAuthoritiesVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/listByMenuId/{menuId:\\d+}")
    @ApiOperation(value = "根据菜单id查询菜单权限",notes = "根据菜单id查询菜单权限")
    public Response<List<SysAuthoritiesVO>> listByMenuId(@PathVariable("menuId") Long menuId) {
        SysAuthoritiesParam param = new SysAuthoritiesParam();
        param.setMenuId(menuId);
        List<SysAuthoritiesDTO> authoritiesList = sysAuthoritiesRepository.list(param);
        return Response.data(ObjectUtils.copyList(authoritiesList,SysAuthoritiesVO.class));
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询系统权限详情",notes = "查询系统权限详情")
    public Response<SysAuthoritiesVO> detail(@PathVariable Long id){
        SysAuthoritiesDTO sysAuthoritiesDTO = sysAuthoritiesRepository.detail(id);
        SysAuthoritiesVO sysAuthoritiesVO = ObjectUtils.copy(sysAuthoritiesDTO,SysAuthoritiesVO.class);
        return Response.data(sysAuthoritiesVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加系统权限",notes = "添加系统权限")
    public Response<Long> create(@RequestBody SysAuthoritiesRequest request){
        SysAuthoritiesDTO sysAuthoritiesDTO = ObjectUtils.copy(request,SysAuthoritiesDTO.class);
        return Response.data(sysAuthoritiesRepository.create(sysAuthoritiesDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改系统权限",notes = "修改系统权限")
    public Response<Boolean> update(@RequestBody SysAuthoritiesRequest request){
        SysAuthoritiesDTO sysAuthoritiesDTO = ObjectUtils.copy(request,SysAuthoritiesDTO.class);
        return Response.data(sysAuthoritiesRepository.update(sysAuthoritiesDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除系统权限",notes = "根据id删除系统权限")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(sysAuthoritiesRepository.delById(id));
    }

}
