package cn.edu.nwpu.salarymanagementsystem.dao

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment
import org.junit.jupiter.api.Test

/**
 * 测试部门树状结构生成情况的测试。
 *
 * @author UnscientificJsZhai
 * @see DepartmentTreeNode
 */
class DepartmentTreeTest {

    @Test
    fun treeTest() {
        val list = ArrayList<MutableDepartment>()

        val d1 = MutableDepartment("d1", null, 1)
        val d2 = MutableDepartment("d2", null, 1)
        val d3 = MutableDepartment("d3", "d1", 2)
        val d4 = MutableDepartment("d4", "d1", 2)
        val d5 = MutableDepartment("d5", "d2", 2)
        val d6 = MutableDepartment("d6", "d4", 3)
        list.add(d1)
        list.add(d2)
        list.add(d3)
        list.add(d4)
        list.add(d5)
        list.add(d6)

        val nodes = DepartmentTreeNode.getTree(list)
        assert(nodes.size == 2)
        val d1n = nodes[0]
        val d2n = nodes[1]
        assert(d1n.data == d1)
        assert(d2n.data == d2)
        assert(d1n.size == 2)
        assert(d2n.size == 1)
        val d3n = d1n[0]
        val d4n = d1n[1]
        val d5n = d2n[0]
        assert(d3n.data == d3)
        assert(d4n.data == d4)
        assert(d5n.data == d5)
        assert(d4n.size == 1)
        val d6n = d4n[0]
        assert(d6n.data == d6)
    }
}