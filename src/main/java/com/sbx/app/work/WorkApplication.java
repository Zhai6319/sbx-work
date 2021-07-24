package com.sbx.app.work;

import com.sbx.core.cloud.annotation.CloudConfigure;
import com.sbx.core.launch.Application;
import com.sbx.core.redis.annotation.EnableRedis;
import com.sbx.core.web.EnableAuth;
import com.sbx.core.web.EnableLog;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>UserApplication class:</p>
 *
 * @author zhaijianchao
 * @version 1.0.0
 * @date 2020/3/21
 */
@EnableLog
@EnableAuth
@EnableRedis
@EnableDubbo
@EnableSwagger2
@CloudConfigure
public class WorkApplication {

    public static void main(String[] args) {
        Application.run("sbx-work",WorkApplication.class,args);
    }

}
