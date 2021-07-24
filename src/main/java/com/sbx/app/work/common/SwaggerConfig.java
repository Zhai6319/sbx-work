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
                .groupName("vehicles")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.vehicles.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(vehiclesApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo vehiclesApiInfo() {
        return new ApiInfoBuilder()
                .title("车辆管理")
                .description("车辆管理API文档")
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
    public Docket createStationRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("station")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.station.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(stationApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo stationApiInfo() {
        return new ApiInfoBuilder()
                .title("驿站管理")
                .description("驿站管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createPartnerRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("partner")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.partner.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(partnerApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo partnerApiInfo() {
        return new ApiInfoBuilder()
                .title("合伙人管理")
                .description("合伙人管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createNotifyRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("notify")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.notify.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(notifyApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo notifyApiInfo() {
        return new ApiInfoBuilder()
                .title("系统通知")
                .description("系统通知API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createHelpRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("help")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.help.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(helpApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo helpApiInfo() {
        return new ApiInfoBuilder()
                .title("客服中心")
                .description("客服中心API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createOrderRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("order")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.order.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(orderApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo orderApiInfo() {
        return new ApiInfoBuilder()
                .title("订单管理")
                .description("订单管理API文档")
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
    public Docket createSettingsRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("settings")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.settings.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(settingsApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo settingsApiInfo() {
        return new ApiInfoBuilder()
                .title("设置信息")
                .description("设置信息API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createBusinessRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("business")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.business.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(businessApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo businessApiInfo() {
        return new ApiInfoBuilder()
                .title("业务管理")
                .description("业务管理API文档")
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
    public Docket createAccountRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("account")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.account.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(accountApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo accountApiInfo() {
        return new ApiInfoBuilder()
                .title("账户管理")
                .description("账户管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createDataRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("data")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.data.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(dataApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo dataApiInfo() {
        return new ApiInfoBuilder()
                .title("数据管理")
                .description("数据管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createDriverRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("driver")
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.sbx.app.work.driver.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(driverApiInfo())
                .globalRequestParameters(parameters());
    }

    private ApiInfo driverApiInfo() {
        return new ApiInfoBuilder()
                .title("司机管理")
                .description("司机管理API文档")
                .license("license by sbx")
                .version("1.0")
                .build();
    }
}
