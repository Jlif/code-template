package tech.jiangchen.springbootdemo.mapper.test2;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangchen.springbootdemo.entity.test2.User2;
import tech.jiangchen.springbootdemo.entity.test2.User2Example;

public interface User2Mapper {
    long countByExample(User2Example example);

    int deleteByExample(User2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(User2 row);

    int insertSelective(User2 row);

    List<User2> selectByExample(User2Example example);

    User2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") User2 row, @Param("example") User2Example example);

    int updateByExample(@Param("row") User2 row, @Param("example") User2Example example);

    int updateByPrimaryKeySelective(User2 row);

    int updateByPrimaryKey(User2 row);
}