package cn.edu.nwpu.salarymanagementsystem.pojo.exception

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment

/**
 * 部门信息包含等级。设置父部门时，父部门的等级必须是当前部门的等级-1。
 * 如果不符合此要求，在写入数据库之前会抛出此异常。
 */
class DepartmentLevelException(val parent: MutableDepartment, val child: MutableDepartment) :
    Exception() {

    private val parentLevel: Int
        get() = parent.level
    private val childLevel: Int
        get() = child.level

    override fun toString(): String {
        return "Child Department's Level must be Parent Department's Level minus 1.\ncurrent parent:$parentLevel\ncurrent child:$$childLevel"
    }
}