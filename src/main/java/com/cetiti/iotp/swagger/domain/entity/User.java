package com.cetiti.iotp.swagger.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户模型
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 16:21:25
 */
@Data
@ApiModel("用户模型")
public class User {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
