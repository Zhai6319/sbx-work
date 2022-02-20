package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelRegionDTO;
import com.sbx.app.travel.params.TravelRegionParam;
import com.sbx.app.work.travel.repository.TravelRegionRepository;
import com.sbx.app.work.travel.request.TravelRegionRequest;
import com.sbx.app.work.travel.vo.TravelRegionVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 区域信息 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "区域信息接口")
@RequestMapping("/travel/travel-region")
public class TravelRegionController {

    @Resource
    private TravelRegionRepository travelRegionRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询区域信息列表",notes = "分页查询区域信息列表")
    public Response<PageResult<TravelRegionVO>> page(TravelRegionRequest request){
        TravelRegionParam param = ObjectUtils.copy(request,TravelRegionParam.class);
        PageResult<TravelRegionDTO> dtoPageResult = travelRegionRepository.page(param);
        PageResult<TravelRegionVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelRegionVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询区域信息详情",notes = "查询区域信息详情")
    public Response<TravelRegionVO> detail(@PathVariable Long id){
        TravelRegionDTO travelRegionDTO = travelRegionRepository.detail(id);
        TravelRegionVO travelRegionVO = ObjectUtils.copy(travelRegionDTO,TravelRegionVO.class);
        return Response.data(travelRegionVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加区域信息",notes = "添加区域信息")
    public Response<Long> create(@RequestBody TravelRegionRequest request){
        TravelRegionDTO travelRegionDTO = ObjectUtils.copy(request,TravelRegionDTO.class);
        return Response.data(travelRegionRepository.create(travelRegionDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改区域信息",notes = "修改区域信息")
    public Response<Boolean> update(@RequestBody TravelRegionRequest request){
        TravelRegionDTO travelRegionDTO = ObjectUtils.copy(request,TravelRegionDTO.class);
        return Response.data(travelRegionRepository.update(travelRegionDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除区域信息",notes = "根据id删除区域信息")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelRegionRepository.delById(id));
    }

}
