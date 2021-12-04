package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class DateTag extends SimpleTagSupport {

    private List<? extends Salary> salaryList;
    private Staff staff;
    private Administrator administrator;

    public void setSalaryList(List<? extends Salary> salaryList) {
        this.salaryList = salaryList;
    }
    public void setStaff(Staff staff) {this.staff = staff;}
    public void setAdministrator(Administrator administrator){this.administrator = administrator;}
    /**
     * 显示日期的自定义标签
     *
     * @throws JspException
     * @throws IOException
     */
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        int[] monthList = new int[salaryList.size()];
        int year = 2000;

        for (int i = 0; i < salaryList.size(); i++) {
            monthList[i] = salaryList.get(i).getMonth();
        }

        for (int i = 0; i < monthList.length; i++) {
            year += monthList[i] / 12;
            monthList[i] = monthList[i] % 12;
        }

        StringBuilder outPrint = new StringBuilder(
                "    <tr>\n" +
                        "        <th>日期</th>\n" +
                        "        <th>岗位工资</th>\n" +
                        "        <th>绩效工资</th>\n" +
                        "        <th>工龄工资</th>\n" +
                        "        <th>补贴</th>\n" +
                        "        <th>是否已发放工资</th>\n");
        if(administrator != null){
            outPrint.append("<th>操作</th>\n");
        }
        outPrint.append("</tr>\n");

        if(staff != null){
            for (int i = 0; i < monthList.length; i++) {
                outPrint.append("<tr>\n" +
                        "<td>" + year+"-"+ monthList[i] +"</td>\n" +
                        "<td>" + salaryList.get(i).getPostWage() +"</td>\n" +
                        "<td>" + salaryList.get(i).getMeritPay() +"</td>\n" +
                        "<td>" + salaryList.get(i).getSeniorityPay() +"</td>\n" +
                        "<td>" + salaryList.get(i).getSubsidy() +"</td>\n" +
                        "<td>" + salaryList.get(i).isPaid() +"</td>\n" +
                        "</tr>");
            }
        }
        else{
            for (int i = 0; i < monthList.length; i++) {
                outPrint.append("<tr>\n" +
                        "<td>" + year+"-"+ monthList[i] +"</td>\n" +
                        "<td>" + "<input name=\"postWage\" type=\"text\" value=\"" + salaryList.get(i).getPostWage() +"\" ></td>\n" +
                        "<td>" + "<input name=\"postWage\" type=\"text\" value=\""+ salaryList.get(i).getMeritPay() +"\" ></td>\n" +
                        "<td>" + "<input name=\"postWage\" type=\"text\" value=\""+ salaryList.get(i).getSeniorityPay() +"\" ></td>\n" +
                        "<td>" + "<input name=\"postWage\" type=\"text\" value=\""+salaryList.get(i).getSubsidy() +"\" ></td>\n" +
                        "<td>" + "<input name=\"postWage\" type=\"text\" value=\""+salaryList.get(i).isPaid() +"\" ></td>\n");
                if(administrator != null){
                    outPrint.append("<td><input type=\"submit\" value=\"修改\"></td>\n");
                }
                outPrint.append("</tr>");
            }
        }
        out.println(outPrint.toString());
    }
}
