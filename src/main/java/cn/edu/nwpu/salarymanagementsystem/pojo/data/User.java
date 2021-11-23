package cn.edu.nwpu.salarymanagementsystem.pojo.data;

/**
 * @ClassName User
 * @Description TODO
 * @Author mikasa
 * @Date 2021/11/21
 * @Version 1.0
 */
public class User {

    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return id+"  "+name+"  "+pwd;
    }
}
