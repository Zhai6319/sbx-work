package com.sbx.app.work.system.controller;


import com.sbx.app.system.dto.SysAuthoritiesDTO;
import com.sbx.app.system.dto.SysMenuDTO;
import com.sbx.app.system.params.ChangeSortParam;
import com.sbx.app.system.params.SaveMenuAuthorityParam;
import com.sbx.app.system.params.SysMenuParam;
import com.sbx.app.work.system.repository.SysMenuRepository;
import com.sbx.app.work.system.request.ChangeSortRequest;
import com.sbx.app.work.system.request.MenuTreeRequest;
import com.sbx.app.work.system.request.SaveMenuAuthorityRequest;
import com.sbx.app.work.system.request.SysMenuRequest;
import com.sbx.app.work.system.vo.MenuTreeVO;
import com.sbx.app.work.system.vo.SysAuthoritiesVO;
import com.sbx.app.work.system.vo.SysMenuVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.node.ForestNodeMerger;
import com.sbx.core.model.validator.Validator;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统菜单 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "系统菜单接口")
@RequestMapping("/system/menu")
public class SysMenuController {

    @Resource
    private SysMenuRepository sysMenuRepository;

    @GetMapping("")
    @ApiOperation(value = "菜单树形结构列表",notes = "菜单树形结构列表")
    public Response<List<MenuTreeVO>> menuAndButtonsTree(MenuTreeRequest request){
        List<SysMenuDTO> dtoList = sysMenuRepository.listMenuByAscription(request.getAscription(),request.getType());
        List<MenuTreeVO> voList = ObjectUtils.copyList(dtoList,MenuTreeVO.class);
        return Response.data(ForestNodeMerger.merge(voList));
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询系统菜单详情",notes = "查询系统菜单详情")
    public Response<SysMenuVO> detail(@PathVariable Long id){
        SysMenuDTO sysMenuDTO = sysMenuRepository.detail(id);
        SysMenuVO sysMenuVO = ObjectUtils.copy(sysMenuDTO,SysMenuVO.class);
        return Response.data(sysMenuVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加系统菜单",notes = "添加系统菜单")
    public Response<Long> create(@RequestBody SysMenuRequest request){
        SysMenuDTO sysMenuDTO = ObjectUtils.copy(request,SysMenuDTO.class);
        return Response.data(sysMenuRepository.create(sysMenuDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改系统菜单",notes = "修改系统菜单")
    public Response<Boolean> update(@RequestBody SysMenuRequest request){
        SysMenuDTO sysMenuDTO = ObjectUtils.copy(request,SysMenuDTO.class);
        return Response.data(sysMenuRepository.update(sysMenuDTO));
    }

    @PutMapping("updateSort")
    @ApiOperation(value = "修改菜单排序",notes = "修改菜单排序")
    public Response<Boolean> updateSort(@RequestBody ChangeSortRequest request){
        Validator.getInstance()
                .notNull(request.getId(),"id")
                .notNull(request.getSortType(),"sortType");
        ChangeSortParam param = new ChangeSortParam();
        param.setCurrentId(request.getId());
        param.setSortType(request.getSortType());
        return Response.data(sysMenuRepository.changeSort(param));
    }

    @PostMapping("/saveMenuAuthority")
    @ApiOperation(value = "保存菜单权限",notes = "保存菜单权限")
    public Response<Boolean> saveMenuAuthority(@RequestBody SaveMenuAuthorityRequest request){
        List<SysAuthoritiesDTO> authorities = ObjectUtils.copyList(request.getAuthorities(), SysAuthoritiesDTO.class);
        SaveMenuAuthorityParam param = new SaveMenuAuthorityParam();
        param.setMenuId(request.getMenuId());
        param.setModule(request.getModule());
        param.setSysAuthorities(authorities);
        return Response.data(sysMenuRepository.batchCreateAuthority(param));
    }

    @GetMapping("/menuAuthorities/{id:\\d+}")
    @ApiOperation(value = "菜单权限列表",notes = "菜单权限列表")
    public Response<List<SysAuthoritiesVO>> menuAuthorities(@PathVariable Long id){
        Validator.getInstance().notNull(id,"id");
        List<SysAuthoritiesDTO> dtoList = sysMenuRepository.menuAuthorities(id);
        return Response.data(ObjectUtils.copyList(dtoList,SysAuthoritiesVO.class));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除系统菜单",notes = "根据id删除系统菜单")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(sysMenuRepository.delById(id));
    }

}
