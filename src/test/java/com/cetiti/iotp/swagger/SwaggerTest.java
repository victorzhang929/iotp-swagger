package com.cetiti.iotp.swagger;

import com.cetiti.iotp.swagger.config.IotpProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Swagger测试类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 15:22:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SwaggerApplication.class)
public class SwaggerTest {

    @Autowired
    private IotpProperties iotpProperties;

    @Test
    public void testIotpProperties() {
        Assert.assertEquals("v3.3", iotpProperties.getVersion());
    }
}
