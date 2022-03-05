package com.sbx.app.work.applet.repository;

import com.sbx.app.applet.api.IAppletNavApi;
import com.sbx.app.applet.dto.AppletNavDTO;
import com.sbx.app.applet.params.AppletNavParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 小程序菜单栏 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-03-05
 */
@Service
public class AppletNavRepository {


    @DubboReference
    private IAppletNavApi iAppletNavApi;

    /**
     * 分页查询小程序菜单栏
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<AppletNavDTO> page(AppletNavParam param){
        return iAppletNavApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取小程序菜单栏
     * @param id    用户ID
     * @return      返回小程序菜单栏
     */
    public AppletNavDTO detail(Long id){
        return iAppletNavApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建小程序菜单栏
     * @param appletNavDTO  小程序菜单栏
     * @return              返回创建数据id
     */
    public Long create(AppletNavDTO appletNavDTO){
        return iAppletNavApi.create(appletNavDTO).computeDataOrFailThrow();
    }

    /**
     * 修改小程序菜单栏
     * @param appletNavDTO  小程序菜单栏
     * @return              返回修改结果
     */
    public Boolean update(AppletNavDTO appletNavDTO) {
        return iAppletNavApi.update(appletNavDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除小程序菜单栏
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iAppletNavApi.delById(id).computeDataOrFailThrow();
    }

}