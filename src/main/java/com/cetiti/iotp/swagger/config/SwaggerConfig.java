package com.cetiti.iotp.swagger.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 10:57:17
 */
@EnableSwagger2
@Configuration
@ConditionalOnProperty(prefix = "iotp", name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {

    @Autowired
    private IotpProperties iotpProperties;

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * 创建Api应用
     * select()函数返回ApiSelectorBuilder实例，用来控制哪些接口暴露给Swagger展示
     * 此处为包含ApiOperation注解的方法暴露给Swagger展示
     * @return RestApi应用
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建Api基本信息，该信息会展示在文档页面中
     * @return Api基本信息
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(getContact())
                .version(iotpProperties.getVersion())
                .build();
    }

    /**
     * 创建Swagger文档联系人信息
     * @return 联系人
     */
    private Contact getContact() {
        return new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail());
    }
}
