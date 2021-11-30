package cn.edu.nwpu.salarymanagementsystem.pojo.exception;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;

/**
 * 当构造{@link MutableDepartment}时层级不为1且没有设定父部门时抛出此异常。
 *
 * @author UnscientificJsZhai
 */
public class DepartmentLevelException extends RuntimeException {

    private final int level;

    public DepartmentLevelException(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        if (level > 1) {
            return "Level " + level + " Department must have parent Department!";
        } else if (level == 1) {
            return "Level 1 Department must not have parent Department";
        } else {
            return "Illegal Level: " + level;
        }
    }
}

