package cn.edu.nwpu.salarymanagementsystem.pojo.data.department

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode.Companion.getTree
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException

/**
 * 显示部门间关系的树状结构。这个类是该树状结构中的节点。使用[getTree]方法获取节点树。
 * 没有统一的根节点
 *
 * @author UnscientificJsZhai
 * @version 1
 */
class DepartmentTreeNode private constructor(
    val data: MutableDepartment, private val childDepartment: ArrayList<DepartmentTreeNode> = ArrayList()
) : List<DepartmentTreeNode> by childDepartment {

    /**
     * 用于比较部门之间等级信息的数据类。
     *
     * @see MutableDepartment.level
     */
    class DepartmentLevelComparator : Comparator<MutableDepartment> {

        override fun compare(o1: MutableDepartment, o2: MutableDepartment): Int {
            return o1.level - o2.level
        }
    }

    companion object {

        /**
         * 通过一个部门列表整理得到他们的树状结构。
         *
         * @param departments 所有部门的列表。
         * @return 若干棵树（的根节点）。由于没有统一的根节点，且最上级部门可能不止一个，所以返回一个列表。
         * 直接存放在列表中的节点都是[MutableDepartment.level]为1的节点。
         */
        @Throws(DepartmentTreeException::class)
        @JvmStatic
        fun getTree(departments: List<MutableDepartment>): ArrayList<DepartmentTreeNode> {
            val result = ArrayList<DepartmentTreeNode>()
            val treeNodeMap = HashMap<Long, DepartmentTreeNode>()
            departments.sortedWith(DepartmentLevelComparator())

            for (department in departments) {
                val newTreeNode = DepartmentTreeNode(department)
                if (department.level == 1) {
                    result.add(newTreeNode)
                } else {
                    val parentNode = treeNodeMap[department.parentDepartment] ?: throw DepartmentTreeException()
                    parentNode.add(newTreeNode)
                }
                treeNodeMap[department.id] = newTreeNode
            }
            return result
        }

        /**
         * 拆包部门树状结构。
         *
         * @param nodes 部门树的根节点列表。
         * @return 结果。
         */
        @JvmStatic
        fun unboxDepartments(nodes: List<DepartmentTreeNode>): List<MutableDepartment> {
            val result = ArrayList<MutableDepartment>()

            for (root in nodes) {
                root.addChildToList(result)
            }

            return result
        }
    }

    /**
     * 添加子部门节点。
     *
     * @param child 子部门。
     */
    private fun add(child: DepartmentTreeNode) {
        this.childDepartment.add(child)
    }

    /**
     * 添加一个子部门。
     *
     * @param id 编号。
     * @param child 新部门名。
     */
    fun add(id: Long, child: String) {
        val newDepartment = MutableDepartment(id, child, this.data.id, this.data.level + 1)
        this.add(DepartmentTreeNode(newDepartment))
    }

    /**
     * 深度优先搜索将树中所有节点添加到列表中。
     *
     * @param list 要添加到的列表。
     */
    private fun addChildToList(list: MutableList<in MutableDepartment>) {
        for (child in this) {
            list.add(child.data)
            if (child.size > 0) {
                child.addChildToList(list)
            }
        }
    }
}