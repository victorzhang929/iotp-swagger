package com.cetiti.iotp.swagger;

import com.cetiti.iotp.swagger.config.SwaggerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Swagger启动类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 14:15:10
 */
@SpringBootApplication(scanBasePackages = "com.cetiti.iotp.swagger")
public class SwaggerApplication implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerApplication.class);

    @Autowired
    private SwaggerProperties swaggerProperties;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (swaggerProperties.getEnable()) {
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
        logger.info("iotp-swagger is successful");
    }

}
