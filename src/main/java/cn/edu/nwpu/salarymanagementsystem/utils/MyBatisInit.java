package cn.edu.nwpu.salarymanagementsystem.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyBatisInit
 * @Description 初始化数据库连接服务，得到访问数据库的钥匙 sqlsession
 * @Author mikasa
 * @Date 2021/11/22
 * @Version 1.0
 */
public class MyBatisInit {

    /**
     * 拿到sqlSession，SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
     * 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
     * @return sqlsession
     * @throws IOException 资源获取失败
     */
    public static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
