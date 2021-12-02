package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工。<br/>
 * 表示员工的数据类，可供员工在个人信息界面中维护自己的个人信息。但是对于修改有一定的限制。
 *
 * @author UnscientificJsZhai
 */
public abstract class Staff {

    /**
     * 用户名。
     */
    protected long id;

    /**
     * 真实姓名。
     */
    protected String name;

    /**
     * 手机号。
     */
    protected String phoneNumber;

    /**
     * 电子邮箱。
     */
    protected String email;

    /**
     * 部门。
     */
    protected Long department;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public long getDepartment() {
        return department;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    /**
     * 默认构造方法。
     *
     * @param id          用户名。相当于表中的user_id列。
     * @param name        真实姓名。相当于表中的username列。
     * @param phoneNumber 手机号。
     * @param email       邮箱。
     * @param department  部门名字。可以为空。空表示当前员工没有所属部门，可能是由于所属部门刚被删除。
     */
    public Staff(long id, @NotNull String name, @NotNull String phoneNumber, @NotNull String email, @Nullable Long department) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
    }

    /**
     * 生成用于操作数据库的Map对象。
     *
     * @param password 密码。可以为空，为空是不修改。
     * @return 生成的Map。
     */
    public Map<String, Object> generateMap(@Nullable String password) {
        final HashMap<String, Object> map = new HashMap<>(6);

        map.put(StaffMapper.ID, this.id);
        map.put(StaffMapper.NAME, this.name);
        map.put(StaffMapper.PHONE, this.phoneNumber);
        map.put(StaffMapper.EMAIL, this.email);
        map.put(StaffMapper.DEPARTMENT_ID, this.department);
        if (password != null) {
            map.put(StaffMapper.PASSWORD, password);
        }

        return map;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "username='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
