package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author mikasa
 * @Date 2021/11/21
 * @Version 1.0
 */
public interface UserMapper {
    List<User> selectUser();
}
