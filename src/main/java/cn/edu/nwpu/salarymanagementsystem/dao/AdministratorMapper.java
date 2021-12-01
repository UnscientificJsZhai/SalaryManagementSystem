package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import org.apache.ibatis.annotations.Param;

/**
 * 查询管理员信息的Dao接口。
 *
 * @author mikasa
 */
public interface AdministratorMapper {

    /**
     * 根据姓名和密码检查登录
     *
     * @param administratorId 管理员工号
     * @param password 密码
     * @return 若查询成功返回数据类
     */
    Administrator login(@Param("administratorId") String administratorId, @Param("password") String password);
}
