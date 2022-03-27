package com.sbx.app.work.travel.controller;


import com.sbx.app.travel.dto.TravelGroupDTO;
import com.sbx.app.travel.params.TravelGroupParam;
import com.sbx.app.work.travel.repository.TravelGroupRepository;
import com.sbx.app.work.travel.request.TravelGroupRequest;
import com.sbx.app.work.travel.vo.TravelGroupVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 分组查询 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2022-03-07
 */
@RestController
@Api(tags = "分组查询接口")
@RequestMapping("/travel/group")
public class TravelGroupController {

    @Resource
    private TravelGroupRepository travelGroupRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询分组查询列表",notes = "分页查询分组查询列表")
    public Response<PageResult<TravelGroupVO>> page(TravelGroupRequest request){
        TravelGroupParam param = ObjectUtils.copy(request,TravelGroupParam.class);
        PageResult<TravelGroupDTO> dtoPageResult = travelGroupRepository.page(param);
        PageResult<TravelGroupVO> pageResult = ObjectUtils.copyPage(dtoPageResult,TravelGroupVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询分组查询详情",notes = "查询分组查询详情")
    public Response<TravelGroupVO> detail(@PathVariable Long id){
        TravelGroupDTO travelGroupDTO = travelGroupRepository.detail(id);
        TravelGroupVO travelGroupVO = ObjectUtils.copy(travelGroupDTO,TravelGroupVO.class);
        return Response.data(travelGroupVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加分组查询",notes = "添加分组查询")
    public Response<Long> create(@RequestBody TravelGroupRequest request){
        TravelGroupDTO travelGroupDTO = ObjectUtils.copy(request,TravelGroupDTO.class);
        return Response.data(travelGroupRepository.create(travelGroupDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改分组查询",notes = "修改分组查询")
    public Response<Boolean> update(@RequestBody TravelGroupRequest request){
        TravelGroupDTO travelGroupDTO = ObjectUtils.copy(request,TravelGroupDTO.class);
        return Response.data(travelGroupRepository.update(travelGroupDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除分组查询",notes = "根据id删除分组查询")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(travelGroupRepository.delById(id));
    }

}
