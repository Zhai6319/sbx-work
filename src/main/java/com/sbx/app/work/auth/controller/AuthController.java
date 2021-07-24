package com.sbx.app.work.auth.controller;

import com.sbx.app.user.dto.UserAuthDTO;
import com.sbx.app.user.dto.UserNavigationBarDTO;
import com.sbx.app.user.enums.LoginTypeEnum;
import com.sbx.app.user.enums.UserTypeEnum;
import com.sbx.app.user.params.UserAuthParam;
import com.sbx.app.work.auth.request.LoginRequest;
import com.sbx.app.work.auth.vo.AuthUserVO;
import com.sbx.app.work.auth.vo.UserNavigationBarVO;
import com.sbx.app.work.auth.wrappers.AuthWrapper;
import com.sbx.app.work.common.WorkContext;
import com.sbx.app.work.user.repository.UserInfoRepository;
import com.sbx.app.work.user.repository.UserLoginRepository;
import com.sbx.common.cache.CacheNames;
import com.sbx.core.model.api.Response;
import com.sbx.core.model.node.ForestNodeMerger;
import com.sbx.core.redis.cache.SbxRedisCache;
import com.sbx.core.tool.support.Kv;
import com.sbx.core.tool.util.ObjectUtils;
import com.sbx.core.tool.util.StringUtil;
import com.wf.captcha.SpecCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/6/26
 */
@RestController
@Api(value = "授权登录")
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private SbxRedisCache sbxRedisCache;
    @Resource
    private UserLoginRepository userLoginRepository;
    @Resource
    private UserInfoRepository userInfoRepository;

    @GetMapping("/captcha")
    public Response<Kv> captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = StringUtil.randomUUID();
        // 存入redis并设置过期时间为30分钟
        sbxRedisCache.setEx(CacheNames.CAPTCHA_KEY + key, verCode, Duration.ofMinutes(5));
        // 将key和base64返回给前端
        return Response.data(Kv.create().set("key", key).set("image", specCaptcha.toBase64()));
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "管理员登陆",notes = "管理员登陆")
    public Response<AuthUserVO> login(@RequestBody LoginRequest request){
        String code = sbxRedisCache.get(CacheNames.CAPTCHA_KEY + request.getKey());
        if (!Objects.equals(request.getCode().toLowerCase(),code)) {
            return Response.fail("验证码错误");
        }
        UserAuthParam param = ObjectUtils.copy(request,UserAuthParam.class);
        param.setSecretKey(request.getPassword());
        param.setLoginType(LoginTypeEnum.PASSWORD.getCode());
        param.setUserType(UserTypeEnum.ADMIN.getCode());
        UserAuthDTO userAuth = userLoginRepository.userAuth(param);
        return Response.data(ObjectUtils.copy(userAuth,AuthUserVO.class));
    }

    @GetMapping(value = "/nav")
    @ApiOperation(value = "管理员导航菜单",notes = "管理员导航菜单")
    public Response<List<UserNavigationBarVO>> nav(){
        List<UserNavigationBarDTO> navList = userInfoRepository.userNavigationBarList(WorkContext.getUserId());
        List<UserNavigationBarVO> navTreeList = AuthWrapper.convertList(navList);
        return Response.data(ForestNodeMerger.merge(navTreeList));
    }

    @GetMapping(value = "/router")
    @ApiOperation(value = "获取路由信息",notes = "获取路由信息")
    public Response<UserNavigationBarVO> router(String path){
        UserNavigationBarDTO router = userInfoRepository.router(WorkContext.getUserId(),path);
        UserNavigationBarVO routerVO = AuthWrapper.convertVO(router);
        return Response.data(routerVO);
    }

    @GetMapping(value = "/routeChain")
    @ApiOperation(value = "获取路由关系列",notes = "获取路由关系列")
    public Response<List<UserNavigationBarVO>> routeChain(String path) {
        List<UserNavigationBarDTO> routeList = userInfoRepository.routeChain(WorkContext.getUserId(),path);
        return Response.data(AuthWrapper.convertList(routeList));
    }


}
