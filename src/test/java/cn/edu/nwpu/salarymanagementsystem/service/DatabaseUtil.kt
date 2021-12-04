package cn.edu.nwpu.salarymanagementsystem.service

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode

/**
 * 清理部门数据库。
 *
 * @receiver 管理员Service。
 */
internal fun AdministratorService.clearDepartment() {
    val departments = departmentList
    departments.sortWith(DepartmentTreeNode.DepartmentLevelComparator())
    departments.reverse()
    for (department in departments) {
        deleteDepartments(department.id)
    }
}

/**
 * 清理员工数据库。
 *
 * @receiver 管理员Service。
 */
internal fun AdministratorService.clearStaff() {
    val staffList = staffList
    for (staff in staffList) {
        deleteStaff(staff.id)
    }
}