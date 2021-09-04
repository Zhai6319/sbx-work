package com.sbx.app.work.product.controller;


import com.sbx.app.product.dto.ProductDeclareDTO;
import com.sbx.app.product.params.ProductDeclareParam;
import com.sbx.app.work.product.repository.ProductDeclareRepository;
import com.sbx.app.work.product.request.ProductDeclareRequest;
import com.sbx.app.work.product.vo.ProductDeclareVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.base.result.PageResult;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 产品声明 前端控制器
 * </p>
 *
 * @author Z.jc
 * @since 2021-07-24
 */
@RestController
@Api(tags = "产品声明接口")
@RequestMapping("/product/declare")
public class ProductDeclareController {

    @Resource
    private ProductDeclareRepository productDeclareRepository;

    @GetMapping("")
    @ApiOperation(value = "分页查询产品声明列表",notes = "分页查询产品声明列表")
    public Response<PageResult<ProductDeclareVO>> page(ProductDeclareRequest request){
        ProductDeclareParam param = ObjectUtils.copy(request,ProductDeclareParam.class);
        PageResult<ProductDeclareDTO> dtoPageResult = productDeclareRepository.page(param);
        PageResult<ProductDeclareVO> pageResult = ObjectUtils.copyPage(dtoPageResult,ProductDeclareVO.class);
        return Response.data(pageResult);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "查询产品声明详情",notes = "查询产品声明详情")
    public Response<ProductDeclareVO> detail(@PathVariable Long id){
        ProductDeclareDTO productDeclareDTO = productDeclareRepository.detail(id);
        ProductDeclareVO productDeclareVO = ObjectUtils.copy(productDeclareDTO,ProductDeclareVO.class);
        return Response.data(productDeclareVO);
    }

    @PostMapping("")
    @ApiOperation(value = "添加产品声明",notes = "添加产品声明")
    public Response<Long> create(@RequestBody ProductDeclareRequest request){
        ProductDeclareDTO productDeclareDTO = ObjectUtils.copy(request,ProductDeclareDTO.class);
        return Response.data(productDeclareRepository.create(productDeclareDTO));
    }

    @PutMapping("")
    @ApiOperation(value = "修改产品声明",notes = "修改产品声明")
    public Response<Boolean> update(@RequestBody ProductDeclareRequest request){
        ProductDeclareDTO productDeclareDTO = ObjectUtils.copy(request,ProductDeclareDTO.class);
        return Response.data(productDeclareRepository.update(productDeclareDTO));
    }

    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "根据id删除产品声明",notes = "根据id删除产品声明")
    public Response<Boolean> delete(@PathVariable(value = "id") Long id){
        return Response.data(productDeclareRepository.delById(id));
    }

}
