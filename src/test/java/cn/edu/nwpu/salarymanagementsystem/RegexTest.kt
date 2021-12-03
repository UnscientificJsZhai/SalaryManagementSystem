package cn.edu.nwpu.salarymanagementsystem

import cn.edu.nwpu.salarymanagementsystem.utils.isEmail
import cn.edu.nwpu.salarymanagementsystem.utils.isPhone
import org.junit.Test

class RegexTest {

    @Test
    fun regexTest() {
        assert(isEmail("123456@example.com"))
        assert(!isEmail("abcd@example"))
        assert(isPhone("12312341234"))
        assert(!isPhone("abc"))
    }
}