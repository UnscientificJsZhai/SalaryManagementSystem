package cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator;

import org.jetbrains.annotations.NotNull;

/**
 * 管理员。<br/>
 * 管理员数据类，用于显示管理员身份信息。
 *
 * @author UnscientificJsZhai
 */
final public class Administrator {

    /**
     * 用户名。
     */
    private String username;

    /**
     * 真实姓名。
     */
    private String name;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * 默认构造方法。
     *
     * @param username 用户名。
     * @param name     真实姓名。
     */
    public Administrator(@NotNull String username, @NotNull String name) {
        this.username = username;
        this.name = name;
    }
}
