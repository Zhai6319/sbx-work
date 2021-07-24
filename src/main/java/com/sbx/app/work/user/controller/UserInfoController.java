package com.sbx.app.work.user.controller;


import com.sbx.app.user.dto.UserInfoDTO;
import com.sbx.app.user.dto.UserInfoDetailDTO;
import com.sbx.app.user.enums.UserSourceEnum;
import com.sbx.app.user.enums.UserTypeEnum;
import com.sbx.app.user.params.UserInfoParam;
import com.sbx.app.work.user.repository.UserInfoRepository;
import com.sbx.app.work.user.request.UserInfoQueryRequest;
import com.sbx.app.work.user.request.UserInfoRequest;
import com.sbx.app.work.user.service.IUserService;
import com.sbx.app.work.user.vo.UserInfoVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-06-26
 */
@RestController
@Api(tags = "用户信息接口")
@RequestMapping("/user/info")
public class UserInfoController {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private IUserService iUserService;

    @GetMapping("")
    @ApiOperation(value = "分页查询用户信息列表",notes = "分页查询用户信息列表")
    public Response<PageResult<UserInfoVO>> page(UserInfoQueryRequest request){
        return Response.data(iUserService.userPage(request));
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询用户信息详情",notes = "查询用户信息详情")
    public Response<UserInfoVO> detail(@PathVariable Long id){
        UserInfoDTO userInfoDTO = userInfoRepository.detail(id);
        UserInfoVO userInfoVO = ObjectUtils.copy(userInfoDTO,UserInfoVO.class);
        return Response.data(userInfoVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加用户信息",notes = "添加用户信息")
    public Response<Long> create(@RequestBody UserInfoRequest request){
        UserInfoDTO userInfoDTO = ObjectUtils.copy(request,UserInfoDTO.class);
        return Response.data(userInfoRepository.create(userInfoDTO,request.getPassword(),request.getRoleIds()));
    }

    @PutMapping("")
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息")
    public Response<Boolean> update(@RequestBody UserInfoRequest request){
        UserInfoDTO userInfoDTO = ObjectUtils.copy(request,UserInfoDTO.class);
        return Response.data(userInfoRepository.update(userInfoDTO,request.getRoleIds()));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除用户信息",notes = "根据id删除用户信息")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(userInfoRepository.delById(id));
    }

}
