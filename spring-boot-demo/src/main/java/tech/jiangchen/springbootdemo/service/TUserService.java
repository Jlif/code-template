package tech.jiangchen.springbootdemo.service;

import tech.jiangchen.springbootdemo.entity.TUser;

import java.util.List;

public interface TUserService {
    List<TUser> findByName(String name);
}
