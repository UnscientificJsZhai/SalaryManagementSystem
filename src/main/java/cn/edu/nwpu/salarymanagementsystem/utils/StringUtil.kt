@file:JvmName("StringUtil")

package cn.edu.nwpu.salarymanagementsystem.utils

private val EMAIL_PATTERN = Regex(
    "[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
)

private val PHONE_PATTERN = Regex(
    "(\\+[0-9]+[\\- .]*)?(\\([0-9]+\\)[\\- .]*)?([0-9][0-9\\- .]+[0-9])"
)

/**
 * 检测字符串是否是电子邮箱。
 *
 * @param input 输入的字符串。
 * @return 是否为电子邮箱。如果是空字符串也返回true。
 */
fun isEmail(input: String) = EMAIL_PATTERN.matches(input) || input.isEmpty()

/**
 * 检测字符串是否是电话号码。
 *
 * @param input 输入的字符串。
 * @return 是否为电话号码。如果是空字符串也返回true。
 */
fun isPhone(input: String) = PHONE_PATTERN.matches(input) || input.isEmpty()

/**
 * 通过输入月份，获取对应的年份。
 *
 * @receiver 月份。
 * @return 年份。1代表2000年，2代表2001年，依次类推。
 */
fun Int.year(): Int = this / 12 + if (this % 12 == 0) 0 else 1

