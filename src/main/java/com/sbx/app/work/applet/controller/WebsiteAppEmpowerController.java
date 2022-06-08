package com.sbx.app.work.applet.controller;


import com.sbx.app.applet.dto.WebsiteAppEmpowerDTO;
import com.sbx.app.applet.params.WebsiteAppEmpowerParam;
import com.sbx.app.work.applet.repository.WebsiteAppEmpowerRepository;
import com.sbx.app.work.applet.request.WebsiteAppEmpowerRequest;
import com.sbx.app.work.applet.vo.WebsiteAppEmpowerVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.model.validator.Validator;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 域名应用授权 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-05-20
 */
@RestController
@Api(tags = "域名应用授权接口")
@RequestMapping("/applet/website-app-empower")
public class WebsiteAppEmpowerController {

    @Resource
    private WebsiteAppEmpowerRepository websiteAppEmpowerRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询域名应用授权列表",notes = "分页查询域名应用授权列表")
    public Response<PageResult<WebsiteAppEmpowerVO>> page(WebsiteAppEmpowerRequest request){
        WebsiteAppEmpowerParam param = ObjectUtils.copy(request,WebsiteAppEmpowerParam.class);
        PageResult<WebsiteAppEmpowerDTO> dtoPageResult = websiteAppEmpowerRepository.page(param);
        PageResult<WebsiteAppEmpowerVO> pageResult = ObjectUtils.copyPage(dtoPageResult,WebsiteAppEmpowerVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询域名应用授权详情",notes = "查询域名应用授权详情")
    public Response<WebsiteAppEmpowerVO> detail(@PathVariable Long id){
        WebsiteAppEmpowerDTO websiteAppEmpowerDTO = websiteAppEmpowerRepository.detail(id);
        WebsiteAppEmpowerVO websiteAppEmpowerVO = ObjectUtils.copy(websiteAppEmpowerDTO,WebsiteAppEmpowerVO.class);
        return Response.data(websiteAppEmpowerVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加域名应用授权",notes = "添加域名应用授权")
    public Response<Long> create(@RequestBody WebsiteAppEmpowerRequest request){
        WebsiteAppEmpowerDTO websiteAppEmpowerDTO = ObjectUtils.copy(request,WebsiteAppEmpowerDTO.class);
        return Response.data(websiteAppEmpowerRepository.create(websiteAppEmpowerDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改域名应用授权",notes = "修改域名应用授权")
    public Response<Boolean> update(@RequestBody WebsiteAppEmpowerRequest request){
        WebsiteAppEmpowerDTO websiteAppEmpowerDTO = ObjectUtils.copy(request,WebsiteAppEmpowerDTO.class);
        return Response.data(websiteAppEmpowerRepository.update(websiteAppEmpowerDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除域名应用授权",notes = "根据id删除域名应用授权")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(websiteAppEmpowerRepository.delById(id));
    }

    @GetMapping("/queryByDomainName")
    @ApiOperation(value = "查询域名应用授权详情",notes = "查询域名应用授权详情")
    public Response<Boolean> queryByDomainName(WebsiteAppEmpowerRequest request){
        Validator.getInstance()
                .notBlank(request.getDomainName(),"domainName")
                .notBlank(request.getAppId(),"appId");
        return Response.data(websiteAppEmpowerRepository.websiteAppEmpower(request.getDomainName(),request.getAppId()));
    }

}
