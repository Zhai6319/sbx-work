package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelDestinationDTO;
import com.sbx.app.travel.params.TravelDestinationParam;
import com.sbx.app.work.travel.repository.TravelDestinationRepository;
import com.sbx.app.work.travel.request.TravelDestinationRequest;
import com.sbx.app.work.travel.vo.TravelDestinationVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 区域目的地 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-02-19
 */
@RestController
@Api(tags = "区域目的地接口")
@RequestMapping("/travel/travel-destination")
public class TravelDestinationController {

    @Resource
    private TravelDestinationRepository travelDestinationRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询区域目的地列表",notes = "分页查询区域目的地列表")
    public Response<PageResult<TravelDestinationVO>> page(TravelDestinationRequest request){
        TravelDestinationParam param = ObjectUtils.copy(request,TravelDestinationParam.class);
        PageResult<TravelDestinationDTO> dtoPageResult = travelDestinationRepository.page(param);
        PageResult<TravelDestinationVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelDestinationVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询区域目的地详情",notes = "查询区域目的地详情")
    public Response<TravelDestinationVO> detail(@PathVariable Long id){
        TravelDestinationDTO travelDestinationDTO = travelDestinationRepository.detail(id);
        TravelDestinationVO travelDestinationVO = ObjectUtils.copy(travelDestinationDTO,TravelDestinationVO.class);
        return Response.data(travelDestinationVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加区域目的地",notes = "添加区域目的地")
    public Response<Long> create(@RequestBody TravelDestinationRequest request){
        TravelDestinationDTO travelDestinationDTO = ObjectUtils.copy(request,TravelDestinationDTO.class);
        return Response.data(travelDestinationRepository.create(travelDestinationDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改区域目的地",notes = "修改区域目的地")
    public Response<Boolean> update(@RequestBody TravelDestinationRequest request){
        TravelDestinationDTO travelDestinationDTO = ObjectUtils.copy(request,TravelDestinationDTO.class);
        return Response.data(travelDestinationRepository.update(travelDestinationDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除区域目的地",notes = "根据id删除区域目的地")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelDestinationRepository.delById(id));
    }

}
