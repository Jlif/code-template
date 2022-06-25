package tech.jiangchen.springbootdemo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.jiangchen.springbootdemo.entity.TUser;

import java.util.List;

public interface TUserRepository extends PagingAndSortingRepository<TUser, Integer> {
    List<TUser> findByName(String name);
}
