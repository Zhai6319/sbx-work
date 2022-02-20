package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelDeclareDTO;
import com.sbx.app.travel.params.TravelDeclareParam;
import com.sbx.app.work.travel.repository.TravelDeclareRepository;
import com.sbx.app.work.travel.request.TravelDeclareRequest;
import com.sbx.app.work.travel.vo.TravelDeclareVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 旅行声明 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "旅行声明接口")
@RequestMapping("/travel/declare")
public class TravelDeclareController {

    @Resource
    private TravelDeclareRepository travelDeclareRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询旅行声明列表",notes = "分页查询旅行声明列表")
    public Response<PageResult<TravelDeclareVO>> page(TravelDeclareRequest request){
        TravelDeclareParam param = ObjectUtils.copy(request,TravelDeclareParam.class);
        PageResult<TravelDeclareDTO> dtoPageResult = travelDeclareRepository.page(param);
        PageResult<TravelDeclareVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelDeclareVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询旅行声明详情",notes = "查询旅行声明详情")
    public Response<TravelDeclareVO> detail(@PathVariable Long id){
        TravelDeclareDTO travelDeclareDTO = travelDeclareRepository.detail(id);
        TravelDeclareVO travelDeclareVO = ObjectUtils.copy(travelDeclareDTO,TravelDeclareVO.class);
        return Response.data(travelDeclareVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加旅行声明",notes = "添加旅行声明")
    public Response<Long> create(@RequestBody TravelDeclareRequest request){
        TravelDeclareDTO travelDeclareDTO = ObjectUtils.copy(request,TravelDeclareDTO.class);
        return Response.data(travelDeclareRepository.create(travelDeclareDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改旅行声明",notes = "修改旅行声明")
    public Response<Boolean> update(@RequestBody TravelDeclareRequest request){
        TravelDeclareDTO travelDeclareDTO = ObjectUtils.copy(request,TravelDeclareDTO.class);
        return Response.data(travelDeclareRepository.update(travelDeclareDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除旅行声明",notes = "根据id删除旅行声明")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelDeclareRepository.delById(id));
    }

}
