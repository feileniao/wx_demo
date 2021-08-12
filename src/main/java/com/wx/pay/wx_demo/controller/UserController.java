package com.wx.pay.wx_demo.controller;

import com.wx.pay.wx_demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feileniao
 * @date 2021/8/9
 * @description
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    final static List<User> result = new ArrayList<>();

    static{
        result.add(new User("aa", 11, "天津", "aa@qq.com"));
        result.add(new User("bb", 12, "北京", "bb@qq.com"));
        result.add(new User("ldh", 13, "山西", "cc@qq.com"));
    }

    @ApiOperation("创建用户")
    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return user;
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return result.get(2);
    }

    @ApiOperation("用户列表")
    @GetMapping
    public List<User> list(@ApiParam("页码") @RequestParam(required = false) int pageIndex, @ApiParam("每页条数") @RequestParam int pageSize) {
        return result;
    }

    @ApiIgnore
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return "delete user:" + id;
    }
}
