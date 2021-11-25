package cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator;

/**
 * 管理员。
 * 管理员数据类，用于显示管理员身份信息。
 *
 * @author UnscientificJsZhai
 * @version 2
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 默认构造方法。
     *
     * @param username 用户名。
     * @param name     真实姓名。
     */
    public Administrator(String username, String name) {
        this.username = username;
        this.name = name;
    }
}
