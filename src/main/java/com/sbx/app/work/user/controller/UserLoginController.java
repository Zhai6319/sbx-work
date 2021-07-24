package com.sbx.app.work.user.controller;


import com.sbx.app.user.dto.UserLoginDTO;
import com.sbx.app.user.params.UserLoginParam;
import com.sbx.app.work.user.repository.UserLoginRepository;
import com.sbx.app.work.user.request.UserLoginRequest;
import com.sbx.app.work.user.vo.UserLoginVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户登录 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "用户登录接口")
@RequestMapping("/user/user-login")
public class UserLoginController {

    @Resource
    private UserLoginRepository userLoginRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询用户登录列表",notes = "分页查询用户登录列表")
    public Response<PageResult<UserLoginVO>> page(UserLoginRequest request){
        UserLoginParam param = ObjectUtils.copy(request,UserLoginParam.class);
        PageResult<UserLoginDTO> dtoPageResult = userLoginRepository.page(param);
        PageResult<UserLoginVO> pageResult = ObjectUtils.copyPage(dtoPageResult,UserLoginVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询用户登录详情",notes = "查询用户登录详情")
    public Response<UserLoginVO> detail(@PathVariable Long id){
        UserLoginDTO userLoginDTO = userLoginRepository.detail(id);
        UserLoginVO userLoginVO = ObjectUtils.copy(userLoginDTO,UserLoginVO.class);
        return Response.data(userLoginVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加用户登录",notes = "添加用户登录")
    public Response<Long> create(@RequestBody UserLoginRequest request){
        UserLoginDTO userLoginDTO = ObjectUtils.copy(request,UserLoginDTO.class);
        return Response.data(userLoginRepository.create(userLoginDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改用户登录",notes = "修改用户登录")
    public Response<Boolean> update(@RequestBody UserLoginRequest request){
        UserLoginDTO userLoginDTO = ObjectUtils.copy(request,UserLoginDTO.class);
        return Response.data(userLoginRepository.update(userLoginDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除用户登录",notes = "根据id删除用户登录")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(userLoginRepository.delById(id));
    }

}
