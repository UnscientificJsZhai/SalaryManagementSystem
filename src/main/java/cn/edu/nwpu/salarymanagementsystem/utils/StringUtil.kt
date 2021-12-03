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
 * @return 是否为电子邮箱。
 */
fun isEmail(input: String) = EMAIL_PATTERN.matches(input)

/**
 * 检测字符串是否是电话号码。
 *
 * @param input 输入的字符串。
 * @return 是否为电话号码。
 */
fun isPhone(input: String) = PHONE_PATTERN.matches(input)

