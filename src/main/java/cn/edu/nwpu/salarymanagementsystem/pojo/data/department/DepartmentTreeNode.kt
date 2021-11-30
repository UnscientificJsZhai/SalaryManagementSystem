package cn.edu.nwpu.salarymanagementsystem.pojo.data.department

import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException

/**
 * 显示部门间关系的树状结构。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
class DepartmentTreeNode private constructor(
    val data: Department,
    private val childDepartment: ArrayList<DepartmentTreeNode> = ArrayList()
) : List<DepartmentTreeNode> by childDepartment {

    /**
     * 用于比较部门之间等级信息的数据类。
     *
     * @see MutableDepartment.level
     */
    private class DepartmentLevelComparator : Comparator<MutableDepartment> {

        override fun compare(o1: MutableDepartment, o2: MutableDepartment): Int {
            return o1.level - o2.level
        }
    }

    companion object {

        /**
         * 通过一个部门列表整理得到他们的树状结构。
         *
         * @param departments 所有部门
         */
        @Throws(DepartmentTreeException::class)
        @JvmStatic
        fun getTree(departments: List<MutableDepartment>): List<DepartmentTreeNode> {
            val result = ArrayList<DepartmentTreeNode>()
            val treeNodeMap = HashMap<String, DepartmentTreeNode>()
            departments.sortedWith(DepartmentLevelComparator())

            for (department in departments) {
                val newTreeNode = DepartmentTreeNode(department)
                if (department.level == 1) {
                    result.add(newTreeNode)
                } else {
                    val parentNode = treeNodeMap[department.parentDepartment] ?: throw DepartmentTreeException()
                    parentNode.add(newTreeNode)
                }
                treeNodeMap[department.getName()] = newTreeNode
            }
            return result
        }
    }

    private fun add(child: DepartmentTreeNode) {
        this.childDepartment.add(child)
    }
}