package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.User;
import cn.edu.nwpu.salarymanagementsystem.utils.MyBatisInit;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
       sqlSession =  MyBatisInit.getSqlSession();
    }

    @Test
    public void testUser(){

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectUser();
        for (User user:list
             ) {
            System.out.println(user);
        }

    }
}