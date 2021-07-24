package com.sbx.app.work.user.controller;


import com.sbx.app.user.dto.UserRoleDTO;
import com.sbx.app.user.params.UserRoleParam;
import com.sbx.app.work.user.repository.UserRoleRepository;
import com.sbx.app.work.user.request.UserRoleRequest;
import com.sbx.app.work.user.vo.UserRoleVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户角色关联表 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "用户角色关联表接口")
@RequestMapping("/user/user-role")
public class UserRoleController {

    @Resource
    private UserRoleRepository userRoleRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询用户角色关联表列表",notes = "分页查询用户角色关联表列表")
    public Response<PageResult<UserRoleVO>> page(UserRoleRequest request){
        UserRoleParam param = ObjectUtils.copy(request,UserRoleParam.class);
        PageResult<UserRoleDTO> dtoPageResult = userRoleRepository.page(param);
        PageResult<UserRoleVO> pageResult = ObjectUtils.copyPage(dtoPageResult,UserRoleVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询用户角色关联表详情",notes = "查询用户角色关联表详情")
    public Response<UserRoleVO> detail(@PathVariable Long id){
        UserRoleDTO userRoleDTO = userRoleRepository.detail(id);
        UserRoleVO userRoleVO = ObjectUtils.copy(userRoleDTO,UserRoleVO.class);
        return Response.data(userRoleVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加用户角色关联表",notes = "添加用户角色关联表")
    public Response<Long> create(@RequestBody UserRoleRequest request){
        UserRoleDTO userRoleDTO = ObjectUtils.copy(request,UserRoleDTO.class);
        return Response.data(userRoleRepository.create(userRoleDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改用户角色关联表",notes = "修改用户角色关联表")
    public Response<Boolean> update(@RequestBody UserRoleRequest request){
        UserRoleDTO userRoleDTO = ObjectUtils.copy(request,UserRoleDTO.class);
        return Response.data(userRoleRepository.update(userRoleDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除用户角色关联表",notes = "根据id删除用户角色关联表")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(userRoleRepository.delById(id));
    }

}
