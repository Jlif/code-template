package tech.jiangchen.springbootdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangchen.springbootdemo.entity.TUser;
import tech.jiangchen.springbootdemo.service.TUserService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class TUserController {

    private final TUserService tUserService;

    @RequestMapping("/findByName")
    public List<TUser> findByName(@RequestParam("name") String name) {
        return tUserService.findByName(name);
    }

}
