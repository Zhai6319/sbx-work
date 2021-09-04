package com.sbx.app.work.product.controller;


import com.sbx.app.product.dto.ProductRegionDTO;
import com.sbx.app.product.params.ProductRegionParam;
import com.sbx.app.work.product.repository.ProductRegionRepository;
import com.sbx.app.work.product.request.ProductRegionRequest;
import com.sbx.app.work.product.vo.ProductRegionVO;
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
 * @since 2021-07-24
 */
@RestController
@Api(tags = "区域信息接口")
@RequestMapping("/product/region")
public class ProductRegionController {

    @Resource
    private ProductRegionRepository productRegionRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询区域信息列表",notes = "分页查询区域信息列表")
    public Response<PageResult<ProductRegionVO>> page(ProductRegionRequest request){
        ProductRegionParam param = ObjectUtils.copy(request,ProductRegionParam.class);
        PageResult<ProductRegionDTO> dtoPageResult = productRegionRepository.page(param);
        PageResult<ProductRegionVO> pageResult = ObjectUtils.copyPage(dtoPageResult,ProductRegionVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询区域信息详情",notes = "查询区域信息详情")
    public Response<ProductRegionVO> detail(@PathVariable Long id){
        ProductRegionDTO productRegionDTO = productRegionRepository.detail(id);
        ProductRegionVO productRegionVO = ObjectUtils.copy(productRegionDTO,ProductRegionVO.class);
        return Response.data(productRegionVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加区域信息",notes = "添加区域信息")
    public Response<Long> create(@RequestBody ProductRegionRequest request){
        ProductRegionDTO productRegionDTO = ObjectUtils.copy(request,ProductRegionDTO.class);
        return Response.data(productRegionRepository.create(productRegionDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改区域信息",notes = "修改区域信息")
    public Response<Boolean> update(@RequestBody ProductRegionRequest request){
        ProductRegionDTO productRegionDTO = ObjectUtils.copy(request,ProductRegionDTO.class);
        return Response.data(productRegionRepository.update(productRegionDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除区域信息",notes = "根据id删除区域信息")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(productRegionRepository.delById(id));
    }

}
