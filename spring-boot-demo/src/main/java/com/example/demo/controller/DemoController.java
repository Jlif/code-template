package com.example.demo.controller;

import com.example.demo.entity.LocalDateTimeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author jiangchen
 * @date 2020/08/04
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String demo(@RequestBody LocalDateTimeEntity entity) {
        System.out.println(entity.getStart());
        return "hello";
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }
}
