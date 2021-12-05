package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import kotlin.Pair;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 在管理员界面展示员工信息的自定义Tag。
 */
public class ShowStaffTag extends SimpleTagSupport {

    private ArrayList<Pair<MutableStaff, String>> staffPairList;

    public void setStaffPairList(ArrayList<Pair<MutableStaff, String>> staffPairList) {
        this.staffPairList = staffPairList;
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        StringBuilder stringBuilder = new StringBuilder("    <tr>\n" + "        <th>员工ID</th>\n" + "        <th>员工姓名</th>\n" + "        <th>部门ID</th>\n" + "        <th>部门名称</th>\n" + "        <th>操作</th>\n" + "        <th></th>\n" + "        </tr>\n");
        for (Pair<MutableStaff, String> mutableStaffStringPair : staffPairList) {
            Staff staff = mutableStaffStringPair.getFirst();
            String departmentName = mutableStaffStringPair.getSecond();
            stringBuilder.append("<tr>\n" + "<td>")
                    .append(staff.getId()).append("</td>\n")
                    .append("<td>").append(staff.getName()).append("</td>\n")
                    .append("<td>").append(staff.getDepartment()).append("</td>\n").append("<td>")
                    .append(departmentName).append("</td>\n").append("<td>")
                    .append("<a href=\"/Admin/ShowInfo").append("?id=").append(staff.getId())
                    .append("\">details</a>").append("</td>\n").append("<td>")
                    .append("<a href=\"/Admin/deleteStaff").append("?id=").append(staff.getId())
                    .append("\">delete</a>").append("</td>\n").append("</tr>");
        }

        out.println(stringBuilder.toString());
    }
}
