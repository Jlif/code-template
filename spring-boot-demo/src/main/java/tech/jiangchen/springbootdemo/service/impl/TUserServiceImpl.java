package tech.jiangchen.springbootdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.jiangchen.springbootdemo.dao.TUserRepository;
import tech.jiangchen.springbootdemo.entity.TUser;
import tech.jiangchen.springbootdemo.service.TUserService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TUserServiceImpl implements TUserService {

    private final TUserRepository tUserRepository;

    @Override
    public List<TUser> findByName(String name) {
        return tUserRepository.findByName(name);
    }
}
