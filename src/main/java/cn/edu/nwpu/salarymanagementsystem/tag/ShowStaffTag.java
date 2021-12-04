package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import kotlin.Pair;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ShowStaffTag extends SimpleTagSupport {

    private ArrayList<Pair<MutableStaff,String>> staffPairList;

    public void setStaffPairList(ArrayList<Pair<MutableStaff,String>> staffPairList){
        this.staffPairList = staffPairList;}

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
        for(int i = 0;i<staffPairList.size();i++){
            Staff staff = staffPairList.get(i).getFirst();
            String departmentName = staffPairList.get(i).getSecond();
            outPrint.append("<tr>\n" +
                    "<td>" +staff.getId() + "</td>\n" +
                    "<td>" + staff.getName() + "</td>\n" +
                    "<td>" + staff.getDepartment() + "</td>\n" +
                    "<td>" + departmentName + "</td>\n" +
                    "<td>" + "<a href=\"/Staff/ShowInfo"+ "?id="+staff.getId()+"\">details</a>"+"</td>\n" +
                    "<td>" + "<a href=\"/Admin/deleteStaff"+ "?id="+staff.getId()+"\">delete</a>"+"</td>\n" +
                    "</tr>");
        }

        out.println(outPrint.toString());
    }
}
