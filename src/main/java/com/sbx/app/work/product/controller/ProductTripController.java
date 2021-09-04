package com.sbx.app.work.product.controller;


import com.sbx.app.product.dto.ProductTripDTO;
import com.sbx.app.product.params.ProductTripParam;
import com.sbx.app.work.product.repository.ProductTripRepository;
import com.sbx.app.work.product.request.ProductTripRequest;
import com.sbx.app.work.product.vo.ProductTripVO;
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
 * @since 2021-07-24
 */
@RestController
@Api(tags = "每日行程介绍接口")
@RequestMapping("/product/trip")
public class ProductTripController {

    @Resource
    private ProductTripRepository productTripRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询每日行程介绍列表",notes = "分页查询每日行程介绍列表")
    public Response<PageResult<ProductTripVO>> page(ProductTripRequest request){
        ProductTripParam param = ObjectUtils.copy(request,ProductTripParam.class);
        PageResult<ProductTripDTO> dtoPageResult = productTripRepository.page(param);
        PageResult<ProductTripVO> pageResult = ObjectUtils.copyPage(dtoPageResult,ProductTripVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询每日行程介绍详情",notes = "查询每日行程介绍详情")
    public Response<ProductTripVO> detail(@PathVariable Long id){
        ProductTripDTO productTripDTO = productTripRepository.detail(id);
        ProductTripVO productTripVO = ObjectUtils.copy(productTripDTO,ProductTripVO.class);
        return Response.data(productTripVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加每日行程介绍",notes = "添加每日行程介绍")
    public Response<Long> create(@RequestBody ProductTripRequest request){
        ProductTripDTO productTripDTO = ObjectUtils.copy(request,ProductTripDTO.class);
        return Response.data(productTripRepository.create(productTripDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改每日行程介绍",notes = "修改每日行程介绍")
    public Response<Boolean> update(@RequestBody ProductTripRequest request){
        ProductTripDTO productTripDTO = ObjectUtils.copy(request,ProductTripDTO.class);
        return Response.data(productTripRepository.update(productTripDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除每日行程介绍",notes = "根据id删除每日行程介绍")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(productTripRepository.delById(id));
    }

}
