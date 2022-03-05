package com.sbx.app.work.applet.controller;


import com.sbx.app.applet.dto.AppletNavDTO;
import com.sbx.app.applet.params.AppletNavParam;
import com.sbx.app.work.applet.repository.AppletNavRepository;
import com.sbx.app.work.applet.request.AppletNavRequest;
import com.sbx.app.work.applet.vo.AppletNavVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 小程序菜单栏 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-03-05
 */
@RestController
@Api(tags = "小程序菜单栏接口")
@RequestMapping("/applet/nav")
public class AppletNavController {

    @Resource
    private AppletNavRepository appletNavRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询小程序菜单栏列表",notes = "分页查询小程序菜单栏列表")
    public Response<PageResult<AppletNavVO>> page(AppletNavRequest request){
        AppletNavParam param = ObjectUtils.copy(request,AppletNavParam.class);
        PageResult<AppletNavDTO> dtoPageResult = appletNavRepository.page(param);
        PageResult<AppletNavVO> pageResult = ObjectUtils.copyPage(dtoPageResult,AppletNavVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询小程序菜单栏详情",notes = "查询小程序菜单栏详情")
    public Response<AppletNavVO> detail(@PathVariable Long id){
        AppletNavDTO appletNavDTO = appletNavRepository.detail(id);
        AppletNavVO appletNavVO = ObjectUtils.copy(appletNavDTO,AppletNavVO.class);
        return Response.data(appletNavVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加小程序菜单栏",notes = "添加小程序菜单栏")
    public Response<Long> create(@RequestBody AppletNavRequest request){
        AppletNavDTO appletNavDTO = ObjectUtils.copy(request,AppletNavDTO.class);
        return Response.data(appletNavRepository.create(appletNavDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改小程序菜单栏",notes = "修改小程序菜单栏")
    public Response<Boolean> update(@RequestBody AppletNavRequest request){
        AppletNavDTO appletNavDTO = ObjectUtils.copy(request,AppletNavDTO.class);
        return Response.data(appletNavRepository.update(appletNavDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除小程序菜单栏",notes = "根据id删除小程序菜单栏")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(appletNavRepository.delById(id));
    }

}
