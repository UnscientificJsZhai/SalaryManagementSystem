@file:JvmName("TaxUtil")

package cn.edu.nwpu.salarymanagementsystem.utils

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary

/**
 * 计算个税。
 *
 * @receiver 薪水列表。
 * @return 计算出的个税数额。
 */
fun List<Salary>.calculateTax(): Double {
    var total = 0.0
    for (salaryItem in this) {
        total += (salaryItem.total() - 5000).coerceAtLeast(0.0)
    }

    return when {
        total <= 36000 -> total * 0.03
        total <= 144000 -> (total - 36000) * 0.1 + 2520
        total <= 300000 -> (total - 144000) * 0.2 + 16920
        total <= 420000 -> (total - 300000) * 0.25 + 31920
        total <= 660000 -> (total - 420000) * 0.3 + 52920
        total <= 960000 -> (total - 660000) * 0.35 + 85920
        else -> (total - 960000) * 0.45 + 181920
    }
}