package cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator;

import org.jetbrains.annotations.NotNull;

/**
 * 管理员。<br/>
 * 管理员数据类，用于显示管理员身份信息。
 *
 * @author UnscientificJsZhai
 */
final public class Administrator {

    private long id;

    /**
     * 真实姓名。
     */
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * 默认构造方法。
     *
     * @param id   用户名。
     * @param name 真实姓名。
     */
    public Administrator(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
