package tech.jiangchen.springbootdemo.service.impl;

import tech.jiangchen.springbootdemo.entity.TUser;
import tech.jiangchen.springbootdemo.dao.TUserMapper;
import tech.jiangchen.springbootdemo.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangchen
 * @since 2022-07-01
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
