package com.sbx.app.work.system.repository;

import com.sbx.app.system.api.ISysOssApi;
import com.sbx.app.system.dto.StsDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/7/28
 */
@Service
public class SysOssRepository {

    @DubboReference
    private ISysOssApi iSysOssApi;

    public StsDTO sts(String fileName){
        return iSysOssApi.sts(fileName).computeDataOrFailThrow();
    }
}
