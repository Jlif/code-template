package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangchen
 * @date 2020/08/04
 */
@Api(tags = "测试接口组")
@RestController
public class DemoController {

    @ApiOperation("根目录")
    @GetMapping("/")
    public String demo() {
        return "hello";
    }

}
