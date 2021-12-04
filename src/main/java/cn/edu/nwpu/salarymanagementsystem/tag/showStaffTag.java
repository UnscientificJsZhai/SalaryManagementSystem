package cn.edu.nwpu.salarymanagementsystem.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class showStaffTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        StringBuilder outPrint = new StringBuilder(
                "    <tr>\n" +
                        "        <th>员工ID</th>\n" +
                        "        <th>员工姓名</th>\n" +
                        "        <th>部门ID</th>\n" +
                        "        <th>部门名称</th>\n" +
                        "        <th>操作</th>\n" +
                        "        </tr>\n");
        for(int i = 0;i<;i++){
            outPrint.append("<tr>\n" +
                    "<td>" +  + "</td>\n" +
                    "<td>" +  + "</td>\n" +
                    "<td>" +  + "</td>\n" +
                    "<td>" +  + "</td>\n" +
                    "<td><a href=\"<c:url value=\"/Admin/searchStaff?sid=${staff.id}\"/>\">查看信息</a></td>" +
                    "<td><a name=\"del\" href=\"#?sid=${staff.id}\">删除</a></td>" +
                    "</tr>");
        }

        out.println(outPrint.toString());
    }
}
