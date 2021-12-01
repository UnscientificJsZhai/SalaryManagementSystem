package cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator;

import org.jetbrains.annotations.NotNull;

/**
 * 管理员。<br/>
 * 管理员数据类，用于显示管理员身份信息。
 *
 * @author UnscientificJsZhai
 * @version 2
 */
final public class Administrator {

    /**
     * 工号
     */
    private String administratorId;

    /**
     * 真实姓名。
     */
    private String name;

    public String getAdministratorId() {
        return administratorId;
    }

    public String getName() {
        return name;
    }

    public void setAdministratorId(@NotNull String administratorId) {
        this.administratorId = administratorId;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * 默认构造方法。
     *
     * @param administratorId 工号
     * @param name     真实姓名。
     */
    public Administrator(@NotNull String administratorId, @NotNull String name) {
        this.administratorId = administratorId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId='" + administratorId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
