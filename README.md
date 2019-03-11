必备知识：[RESTful架构](RESTful.md)

# swagger文档

1. pom引入相关依赖

```java

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.8.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.8.0</version>
</dependency>
```

2. 编写swagger配置文件com.cetiti.iotp.swagger.config.SwaggerConfig，类文件头部添加开关注解，一般生产环境会关闭swagger

``java
@ConditionalOnProperty(prefix = "iotp", name = "swagger.enable", havingValue = "true")
``

3. 配置Iotp项目级配置信息com.cetiti.iotp.swagger.config.IotpProperties，以及swagger配置信息com.cetiti.iotp.swagger.config.SwaggerProperties，它们分别对应了application.properties文件相关内容。

```java
iotp.version=v3.3
iotp.swagger.enable=true
iotp.swagger.title=IOTP-ApiGateway
iotp.swagger.description=IOTP-ApiGateway Swagger document
iotp.swagger.contact-name=IOTP-WEB Develop Team || IOTP-ApiGateway Module || Victor Zhang
iotp.swagger.contact-url=http://www.cethik.com/index.aspx
iotp.swagger.contact-email=zhangwei@cetiti.com
```

4. 案例为用户模块

* 定义com.cetiti.iotp.swagger.domain.entity.User模型类，类文件头部添加@ApiModel注解，属性添加@ApiModelProperty注解。若入参为User在入参前添加@ModelAttribute即可。
* 控制器com.cetiti.iotp.swagger.controller.UserController，类文件头部添加@Api("用户控制器")注解，方法上添加@ApiOperation注解说明方法，@ApiImplicitParam注解说明单个入参，@ApiImplicitParams注解说明多个入参。

5. 完整内容查看源码。