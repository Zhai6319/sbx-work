package com.sbx.app.work.system.controller;

import com.sbx.app.system.dto.StsDTO;
import com.sbx.app.work.system.repository.SysOssRepository;
import com.sbx.app.work.system.vo.StsVO;
import com.sbx.core.model.api.Response;
import com.sbx.core.tool.util.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/28
 */
@RestController
@Api(value = "管理员用户接口")
@RequestMapping("/file")
public class SysFileController {


    @Resource
    private SysOssRepository sysOssRepository;


    @GetMapping(value = "/aliOss/sts")
    @ApiOperation(value = "获取阿里云oss sts临时授权",notes = "获取阿里云oss sts临时授权")
    public Response<StsVO> sts(String fileName){
        StsDTO sts = sysOssRepository.sts(fileName);
        return Response.data(ObjectUtils.copy(sts,StsVO.class,((stsDTO, stsVO) -> {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
            LocalDateTime time = LocalDateTime.parse(stsDTO.getExpiration(),dateTimeFormatter);
            LocalDateTime s = LocalDateTime.ofInstant(time.toInstant(ZoneOffset.UTC), ZoneId.of("GMT+08:00"));
            stsVO.setExpiration(s);
        })));
    }

}
