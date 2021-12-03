package cn.edu.nwpu.salarymanagementsystem.service

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary
import cn.edu.nwpu.salarymanagementsystem.utils.calculateTax
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * 个税计算单元测试。
 *
 * @author UnscientificJsZhai
 */
class CalculateTaxTest {

    /**
     * 桩薪水数据类。
     */
    private class StubSalary(month: Int, private val total: Double) : Salary(month, 0.0, 0.0, 0.0, 0.0, true) {

        override fun total(): Double {
            return total
        }
    }

    /**
     * 工具方法。用过每月工资生成全年工资列表。
     *
     * @receiver 每月工资。
     * @return 工资列表。
     */
    private fun Number.perMonth(): List<Salary> {
        val list = ArrayList<StubSalary>()
        for (month in 1..12) {
            list.add(StubSalary(month = month, total = this.toDouble()))
        }
        return list
    }

    @Test
    fun taxTest() {
        assertEquals(0.0, 5000.perMonth().calculateTax(), 0.01)
        assertEquals(90.0 * 12, 8000.perMonth().calculateTax(), 0.01)
        assertEquals(7320.0, 12000.perMonth().calculateTax(), 0.01)
        assertEquals(12120.0, 16000.perMonth().calculateTax(), 0.01)
    }
}