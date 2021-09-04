package com.sbx.app.work.product.controller;


import com.sbx.app.product.dto.ProductInfoDTO;
import com.sbx.app.product.params.ProductInfoParam;
import com.sbx.app.work.product.repository.ProductInfoRepository;
import com.sbx.app.work.product.request.ProductInfoRequest;
import com.sbx.app.work.product.vo.ProductInfoVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 产品信息 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@RestController
@Api(tags = "产品信息接口")
@RequestMapping("/product/info")
public class ProductInfoController {

    @Resource
    private ProductInfoRepository productInfoRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询产品信息列表",notes = "分页查询产品信息列表")
    public Response<PageResult<ProductInfoVO>> page(ProductInfoRequest request){
        ProductInfoParam param = ObjectUtils.copy(request,ProductInfoParam.class);
        PageResult<ProductInfoDTO> dtoPageResult = productInfoRepository.page(param);
        PageResult<ProductInfoVO> pageResult = ObjectUtils.copyPage(dtoPageResult,ProductInfoVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询产品信息详情",notes = "查询产品信息详情")
    public Response<ProductInfoVO> detail(@PathVariable Long id){
        ProductInfoDTO productInfoDTO = productInfoRepository.detail(id);
        ProductInfoVO productInfoVO = ObjectUtils.copy(productInfoDTO,ProductInfoVO.class);
        return Response.data(productInfoVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加产品信息",notes = "添加产品信息")
    public Response<Long> create(@RequestBody ProductInfoRequest request){
        ProductInfoDTO productInfoDTO = ObjectUtils.copy(request,ProductInfoDTO.class);
        return Response.data(productInfoRepository.create(productInfoDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改产品信息",notes = "修改产品信息")
    public Response<Boolean> update(@RequestBody ProductInfoRequest request){
        ProductInfoDTO productInfoDTO = ObjectUtils.copy(request,ProductInfoDTO.class);
        return Response.data(productInfoRepository.update(productInfoDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除产品信息",notes = "根据id删除产品信息")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(productInfoRepository.delById(id));
    }

}
