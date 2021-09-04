package com.sbx.app.work.product.controller;


import com.sbx.app.product.dto.ProductRegionDestinationDTO;
import com.sbx.app.product.params.ProductRegionDestinationParam;
import com.sbx.app.work.product.repository.ProductRegionDestinationRepository;
import com.sbx.app.work.product.request.ProductRegionDestinationRequest;
import com.sbx.app.work.product.vo.ProductRegionDestinationVO;
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
 * @since 2021-07-24
 */
@RestController
@Api(tags = "区域目的地接口")
@RequestMapping("/product/region-destination")
public class ProductRegionDestinationController {

    @Resource
    private ProductRegionDestinationRepository productRegionDestinationRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询区域目的地列表",notes = "分页查询区域目的地列表")
    public Response<PageResult<ProductRegionDestinationVO>> page(ProductRegionDestinationRequest request){
        ProductRegionDestinationParam param = ObjectUtils.copy(request,ProductRegionDestinationParam.class);
        PageResult<ProductRegionDestinationDTO> dtoPageResult = productRegionDestinationRepository.page(param);
        PageResult<ProductRegionDestinationVO> pageResult = ObjectUtils.copyPage(dtoPageResult,ProductRegionDestinationVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询区域目的地详情",notes = "查询区域目的地详情")
    public Response<ProductRegionDestinationVO> detail(@PathVariable Long id){
        ProductRegionDestinationDTO productRegionDestinationDTO = productRegionDestinationRepository.detail(id);
        ProductRegionDestinationVO productRegionDestinationVO = ObjectUtils.copy(productRegionDestinationDTO,ProductRegionDestinationVO.class);
        return Response.data(productRegionDestinationVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加区域目的地",notes = "添加区域目的地")
    public Response<Long> create(@RequestBody ProductRegionDestinationRequest request){
        ProductRegionDestinationDTO productRegionDestinationDTO = ObjectUtils.copy(request,ProductRegionDestinationDTO.class);
        return Response.data(productRegionDestinationRepository.create(productRegionDestinationDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改区域目的地",notes = "修改区域目的地")
    public Response<Boolean> update(@RequestBody ProductRegionDestinationRequest request){
        ProductRegionDestinationDTO productRegionDestinationDTO = ObjectUtils.copy(request,ProductRegionDestinationDTO.class);
        return Response.data(productRegionDestinationRepository.update(productRegionDestinationDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除区域目的地",notes = "根据id删除区域目的地")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(productRegionDestinationRepository.delById(id));
    }

}
