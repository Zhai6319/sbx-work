package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelRouteDTO;
import com.sbx.app.travel.params.TravelRouteParam;
import com.sbx.app.work.travel.repository.TravelRouteRepository;
import com.sbx.app.work.travel.request.TravelRouteRequest;
import com.sbx.app.work.travel.vo.TravelRouteVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 旅行线路 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "旅行线路接口")
@RequestMapping("/travel/route")
public class TravelRouteController {

    @Resource
    private TravelRouteRepository travelRouteRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询旅行线路列表",notes = "分页查询旅行线路列表")
    public Response<PageResult<TravelRouteVO>> page(TravelRouteRequest request){
        TravelRouteParam param = ObjectUtils.copy(request,TravelRouteParam.class);
        PageResult<TravelRouteDTO> dtoPageResult = travelRouteRepository.page(param);
        PageResult<TravelRouteVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelRouteVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询旅行线路详情",notes = "查询旅行线路详情")
    public Response<TravelRouteVO> detail(@PathVariable Long id){
        TravelRouteDTO travelRouteDTO = travelRouteRepository.detail(id);
        TravelRouteVO travelRouteVO = ObjectUtils.copy(travelRouteDTO,TravelRouteVO.class);
        return Response.data(travelRouteVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加旅行线路",notes = "添加旅行线路")
    public Response<Long> create(@RequestBody TravelRouteRequest request){
        TravelRouteDTO travelRouteDTO = ObjectUtils.copy(request,TravelRouteDTO.class);
        return Response.data(travelRouteRepository.create(travelRouteDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改旅行线路",notes = "修改旅行线路")
    public Response<Boolean> update(@RequestBody TravelRouteRequest request){
        TravelRouteDTO travelRouteDTO = ObjectUtils.copy(request,TravelRouteDTO.class);
        return Response.data(travelRouteRepository.update(travelRouteDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除旅行线路",notes = "根据id删除旅行线路")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelRouteRepository.delById(id));
    }

}
