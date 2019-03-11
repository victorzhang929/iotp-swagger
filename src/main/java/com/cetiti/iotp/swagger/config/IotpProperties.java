package com.cetiti.iotp.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Iotp项目配置
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 14:25:19
 */
@Data
@Component
@ConfigurationProperties(prefix = IotpProperties.IOTP_PREFIX)
public class IotpProperties {

    public static final String IOTP_PREFIX = "iotp";

    /**
     * 项目版本号
     */
    private String version;
}
