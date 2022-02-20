package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelTripDTO;
import com.sbx.app.travel.params.TravelTripParam;
import com.sbx.app.work.travel.repository.TravelTripRepository;
import com.sbx.app.work.travel.request.TravelTripRequest;
import com.sbx.app.work.travel.vo.TravelTripVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 每日行程介绍 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "每日行程介绍接口")
@RequestMapping("/travel/travel-trip")
public class TravelTripController {

    @Resource
    private TravelTripRepository travelTripRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询每日行程介绍列表",notes = "分页查询每日行程介绍列表")
    public Response<PageResult<TravelTripVO>> page(TravelTripRequest request){
        TravelTripParam param = ObjectUtils.copy(request,TravelTripParam.class);
        PageResult<TravelTripDTO> dtoPageResult = travelTripRepository.page(param);
        PageResult<TravelTripVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelTripVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询每日行程介绍详情",notes = "查询每日行程介绍详情")
    public Response<TravelTripVO> detail(@PathVariable Long id){
        TravelTripDTO travelTripDTO = travelTripRepository.detail(id);
        TravelTripVO travelTripVO = ObjectUtils.copy(travelTripDTO,TravelTripVO.class);
        return Response.data(travelTripVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加每日行程介绍",notes = "添加每日行程介绍")
    public Response<Long> create(@RequestBody TravelTripRequest request){
        TravelTripDTO travelTripDTO = ObjectUtils.copy(request,TravelTripDTO.class);
        return Response.data(travelTripRepository.create(travelTripDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改每日行程介绍",notes = "修改每日行程介绍")
    public Response<Boolean> update(@RequestBody TravelTripRequest request){
        TravelTripDTO travelTripDTO = ObjectUtils.copy(request,TravelTripDTO.class);
        return Response.data(travelTripRepository.update(travelTripDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除每日行程介绍",notes = "根据id删除每日行程介绍")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelTripRepository.delById(id));
    }

}
