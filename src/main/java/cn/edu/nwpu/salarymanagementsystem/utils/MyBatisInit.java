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
 * @Version 2.0
 */
public enum MyBatisInit {
    INSTANCE;
    private SqlSessionFactory sqlSessionFactory;

    public SqlSession getSqlSession() throws IOException {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory.openSession();
        } else {
            return sqlSessionFactory.openSession();
        }
    }
}
