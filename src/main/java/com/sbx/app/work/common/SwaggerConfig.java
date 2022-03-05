package com.sbx.app.work.common;

import com.sbx.common.header.HeadName;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Configuration
public class SwaggerConfig {

    private Set<String> produces() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json");
        return produces;
    }

    private List<RequestParameter> parameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder();
        parameterBuilder
                .in(ParameterType.HEADER)
                .name("Access-Token")
                .required(false)
                .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
        parameters.add(parameterBuilder.build());
        parameterBuilder = new RequestParameterBuilder();
        parameterBuilder
                .in(ParameterType.HEADER)
                .name(HeadName.X_ORIGINAL_URL)
                .required(false)
                .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
        parameters.add(parameterBuilder.build());
        return parameters;
    }

    private Class<?>[] ignoredParameterTypes() {
        return new Class[]{HttpSession.class, HttpServletRequest.class, HttpServletResponse.class};
    }


    @Bean
    public Docket createVehiclesRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("travel")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.travel.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(travelApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo travelApiInfo() {
        return new ApiInfoBuilder()
                .title("旅游管理")
                .description("旅游管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createUserRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("user")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.user.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(userApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("用户管理")
                .description("用户管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createSystemRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("system")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.system.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(systemApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo systemApiInfo() {
        return new ApiInfoBuilder()
                .title("系统管理")
                .description("系统管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createAuthRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("auth")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.auth.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(authApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo authApiInfo() {
        return new ApiInfoBuilder()
                .title("授权管理")
                .description("授权管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }


    @Bean
    public Docket createLogRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("log")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.log.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(logApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo logApiInfo() {
        return new ApiInfoBuilder()
                .title("日志管理")
                .description("日志管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createAppletRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("applet")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.applet.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(appletApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo appletApiInfo() {
        return new ApiInfoBuilder()
                .title("小程序管理")
                .description("小程序管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

}
