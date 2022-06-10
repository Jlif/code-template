package tech.jiangchen.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangchen
 * @date 2020/08/04
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String demo() {
        return "hello";
    }

}
