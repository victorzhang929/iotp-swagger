package com.cetiti.iotp.swagger.controller;

import com.cetiti.iotp.swagger.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Index控制器
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @since 2019-03-11 11:50:25
 */
@Api("用户控制器")
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{userId}")
    @ApiOperation(value = "根据用户ID获取用户", tags = "user")
    @ApiImplicitParam(paramType = "query", name = "userId", value = "用户ID", required = true, dataType = "String")
    public String get(@PathVariable("userId") final String userId) {
        return "用户：" + userId;
    }

    @GetMapping
    @ApiOperation(value = "列出所有用户", tags = "user")
    public String list() {
        return "所有用户";
    }

    @PostMapping
    @ApiOperation(value = "更新用户信息", tags = "user")
    public String update(@ModelAttribute final User user) {
        System.out.println(user);
        return "更新用户信息";
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "根据用户ID删除用户", tags = "user")
    @ApiImplicitParam(paramType = "query", name = "userId", value = "用户ID", required = true, dataType = "String")
    public String delete(@PathVariable("userId") final String userId) {
        return "删除用户：" + userId;
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", tags = "user,login")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String")
    })
    public String login(final String username, final String password) {
        return "登录成功\nusername--" + username + "\npassword--" + password;
    }
}
