package com.sbx.app.work.applet.repository;

import com.sbx.app.applet.api.IWebsiteAppEmpowerApi;
import com.sbx.app.applet.dto.WebsiteAppEmpowerDTO;
import com.sbx.app.applet.params.WebsiteAppEmpowerParam;
import com.sbx.core.model.base.result.PageResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 域名应用授权 数据处理
 * </p>
 *
 * @author Z.jc
 * @since 2022-05-20
 */
@Service
public class WebsiteAppEmpowerRepository {


    @DubboReference
    private IWebsiteAppEmpowerApi iWebsiteAppEmpowerApi;

    /**
     * 分页查询域名应用授权
     * @param param 请求参数
     * @return      返回分页列表
     */
    public PageResult<WebsiteAppEmpowerDTO> page(WebsiteAppEmpowerParam param){
        return iWebsiteAppEmpowerApi.queryByCondition(param).computeDataOrFailThrow();
    }

    /**
     * 根据ID获取域名应用授权
     * @param id    用户ID
     * @return      返回域名应用授权
     */
    public WebsiteAppEmpowerDTO detail(Long id){
        return iWebsiteAppEmpowerApi.queryDetailById(id).computeDataOrFailThrow();
    }

    /**
     * 创建域名应用授权
     * @param websiteAppEmpowerDTO  域名应用授权
     * @return              返回创建数据id
     */
    public Long create(WebsiteAppEmpowerDTO websiteAppEmpowerDTO){
        return iWebsiteAppEmpowerApi.create(websiteAppEmpowerDTO).computeDataOrFailThrow();
    }

    /**
     * 修改域名应用授权
     * @param websiteAppEmpowerDTO  域名应用授权
     * @return              返回修改结果
     */
    public Boolean update(WebsiteAppEmpowerDTO websiteAppEmpowerDTO) {
        return iWebsiteAppEmpowerApi.update(websiteAppEmpowerDTO).computeDataOrFailThrow();
    }

    /**
     * 根据id删除域名应用授权
     * @param id    数据id
     * @return      返回删除结果
     */
    public Boolean delById(Long id) {
        return iWebsiteAppEmpowerApi.delById(id).computeDataOrFailThrow();
    }

    /**
     * 根据域名和应用ID判断域名是否授权
     * @param domainName    域名
     * @param appId         应用ID
     * @return              返回结果
     */
    public Boolean websiteAppEmpower(String domainName,String appId) {
        WebsiteAppEmpowerParam param = new WebsiteAppEmpowerParam();
        param.setDomainName(domainName);
        param.setAppId(appId);
        PageResult<WebsiteAppEmpowerDTO> result = iWebsiteAppEmpowerApi.queryByCondition(param).computeDataOrFailThrow();
        return result.getTotal() > 0;
    }

}