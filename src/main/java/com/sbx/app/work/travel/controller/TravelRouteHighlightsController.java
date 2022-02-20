package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelRouteHighlightsDTO;
import com.sbx.app.travel.params.TravelRouteHighlightsParam;
import com.sbx.app.work.travel.repository.TravelRouteHighlightsRepository;
import com.sbx.app.work.travel.request.TravelRouteHighlightsRequest;
import com.sbx.app.work.travel.vo.TravelRouteHighlightsVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 旅游路线亮点 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "旅游路线亮点接口")
@RequestMapping("/travel/travel-route-highlights")
public class TravelRouteHighlightsController {

    @Resource
    private TravelRouteHighlightsRepository travelRouteHighlightsRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询旅游路线亮点列表",notes = "分页查询旅游路线亮点列表")
    public Response<PageResult<TravelRouteHighlightsVO>> page(TravelRouteHighlightsRequest request){
        TravelRouteHighlightsParam param = ObjectUtils.copy(request,TravelRouteHighlightsParam.class);
        PageResult<TravelRouteHighlightsDTO> dtoPageResult = travelRouteHighlightsRepository.page(param);
        PageResult<TravelRouteHighlightsVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelRouteHighlightsVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询旅游路线亮点详情",notes = "查询旅游路线亮点详情")
    public Response<TravelRouteHighlightsVO> detail(@PathVariable Long id){
        TravelRouteHighlightsDTO travelRouteHighlightsDTO = travelRouteHighlightsRepository.detail(id);
        TravelRouteHighlightsVO travelRouteHighlightsVO = ObjectUtils.copy(travelRouteHighlightsDTO,TravelRouteHighlightsVO.class);
        return Response.data(travelRouteHighlightsVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加旅游路线亮点",notes = "添加旅游路线亮点")
    public Response<Long> create(@RequestBody TravelRouteHighlightsRequest request){
        TravelRouteHighlightsDTO travelRouteHighlightsDTO = ObjectUtils.copy(request,TravelRouteHighlightsDTO.class);
        return Response.data(travelRouteHighlightsRepository.create(travelRouteHighlightsDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改旅游路线亮点",notes = "修改旅游路线亮点")
    public Response<Boolean> update(@RequestBody TravelRouteHighlightsRequest request){
        TravelRouteHighlightsDTO travelRouteHighlightsDTO = ObjectUtils.copy(request,TravelRouteHighlightsDTO.class);
        return Response.data(travelRouteHighlightsRepository.update(travelRouteHighlightsDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除旅游路线亮点",notes = "根据id删除旅游路线亮点")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelRouteHighlightsRepository.delById(id));
    }

}
