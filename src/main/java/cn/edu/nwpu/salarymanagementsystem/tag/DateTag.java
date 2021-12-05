package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.utils.StringUtil;

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

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    /**
     * 显示日期的自定义标签。
     */
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        int[][] monthList = new int[2][salaryList.size()];
        int year = 2000;

        for (int i = 0; i < salaryList.size(); i++) {
            monthList[0][i] = StringUtil.year(salaryList.get(i).getMonth()) + year;
            int month = salaryList.get(i).getMonth() % 12;
            if (month == 0) {
                monthList[1][i] = 12;
            } else {
                monthList[1][i] = month;
            }

        }


        StringBuilder outPrint = new StringBuilder(
                "    <tr>\n" +
                        "        <th>日期</th>\n" +
                        "        <th>岗位工资</th>\n" +
                        "        <th>绩效工资</th>\n" +
                        "        <th>工龄工资</th>\n" +
                        "        <th>补贴</th>\n" +
                        "        <th>是否已发放工资</th>\n");
        if (administrator != null) {
            outPrint.append("<th>操作</th>\n");
        }
        outPrint.append("</tr>\n");

        if (administrator != null) {
            for (int i = 0; i < salaryList.size(); i++) {
                Salary salary = salaryList.get(i);
                outPrint.append("<tr>\n" +
                        "<td>" + monthList[0][i] + "-" + monthList[1][i] + "</td>\n" +
                        "<td>" + salary.getPostWage() + "</td>\n" +
                        "<td>" + salary.getMeritPay() + "</td>\n" +
                        "<td>" + salary.getSeniorityPay() + "</td>\n" +
                        "<td>" + salary.getSubsidy() + "</td>\n" +
                        "<td>" + salary.isPaid() + "</td>\n" +
                        "<td>" + "<a href=\"/Admin/editSalary" + "/" + staff.getId() + "/" + salary.getMonth() + "\">edit</a>" + "</td>\n");
                outPrint.append("</tr>");
            }
        } else {
            for (int i = 0; i < salaryList.size(); i++) {
                Salary salary = salaryList.get(i);
                outPrint.append("<tr>\n" +
                        "<td>" + monthList[0][i] + "-" + monthList[1][i] + "</td>\n" +
                        "<td>" + salary.getPostWage() + "</td>\n" +
                        "<td>" + salary.getMeritPay() + "</td>\n" +
                        "<td>" + salary.getSeniorityPay() + "</td>\n" +
                        "<td>" + salary.getSubsidy() + "</td>\n" +
                        "<td>" + salary.isPaid() + "</td>\n" +
                        "</tr>");
            }
        }
        out.print(outPrint.toString());
    }
}
