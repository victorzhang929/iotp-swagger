package com.cetiti.iotp.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Swagger项目配置
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 15:39:39
 */
@Data
@Component
@ConfigurationProperties(prefix = SwaggerProperties.IOTP_SWAGGER_PREFIX)
public class SwaggerProperties {

    public static final String IOTP_SWAGGER_PREFIX = "iotp.swagger";

    private Boolean enable = Boolean.FALSE;
    private String title;
    private String description;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
}
