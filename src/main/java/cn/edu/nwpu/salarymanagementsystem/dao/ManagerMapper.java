package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;

public interface ManagerMapper {

    /**
     * 根据姓名和密码检查登录
     * @param username 管理员用户名
     * @param password 密码
     * @return 若查询成功返回数据类
     */
    Administrator login(String username, String password);
}
