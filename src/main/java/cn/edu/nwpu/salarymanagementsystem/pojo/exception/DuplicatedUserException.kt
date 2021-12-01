package cn.edu.nwpu.salarymanagementsystem.pojo.exception

import java.sql.SQLException

/**
 * 当添加员工信息遇到重复用户名时抛出此异常。
 *
 * @author UnscientificJsZhai
 * @param username 重复的用户名。
 * @param cause 数据库抛出的[SQLException]。
 */
class DuplicatedUserException(private val username: String, cause: Throwable) : Exception(cause) {

    override fun toString() = "Duplicated username: \"$username\""
}