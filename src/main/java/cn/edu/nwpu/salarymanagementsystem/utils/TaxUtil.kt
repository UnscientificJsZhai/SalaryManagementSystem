@file:JvmName("TaxUtil")

package cn.edu.nwpu.salarymanagementsystem.utils

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary

/**
 * 计算个税。
 *
 * @receiver 薪水列表。
 * @return 计算出的个税数额。
 */
private fun List<Salary>.calculateTax(): Double {
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

private val comparator = Comparator<Salary> { o1, o2 -> o1.month - o2.month }

/**
 * 按年份分别计算不同年的个税。
 *
 * @receiver 所有工资信息。
 * @return 年份和个税数目的配对列表。
 */
fun List<Salary>.totalTax(): List<Pair<Int, Double>> {
    this.sortedWith(comparator)
    val result = ArrayList<Pair<Int, Double>>()
    val maxMonth = maxOf {
        it.month
    }
    val maxYear = maxMonth / 12 + if (maxMonth % 12 == 0) 0 else 1
    val sublist = ArrayList<Salary>()
    for (year in 1..maxYear) {
        sublist.clear()
        for (salary in this) {
            if (salary.month > year * 12) {
                break
            } else if (salary.month > year * 12 - 12) {
                sublist.add(salary)
            }
        }
        result.add(Pair(year + 1999, sublist.calculateTax()))
    }
    return result
}