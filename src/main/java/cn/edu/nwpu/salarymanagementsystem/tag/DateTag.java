package cn.edu.nwpu.salarymanagementsystem.tag;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class DateTag extends SimpleTagSupport{
    /**
     * 显示日期的自定义标签
     *
     * @throws JspException
     * @throws IOException
     */
    public void doTag() throws JspException , IOException {

        long id = Long.parseLong(getJspBody().toString());
        JspWriter out = getJspContext().getOut();
        List <? extends Salary> salaryList = new StaffService().getSalaryList(id);
        int[] monthList = null;
        int year = 2000;

        for(int i = 0;i<salaryList.size();i++){
            monthList[i] = salaryList.get(i).getMonth();
        }

        for(int i = 0;i<monthList.length;i++){
            year += monthList[i]/12;
            monthList[i] = monthList[i]%12;
        }

        StringBuilder outPrint = new StringBuilder("<table>\n" +
                "    <tr>\n" +
                "        <th>日期</th>\n" +
                "    </tr>\n" +
                "    <tr>\n");
        for(int i = 0;i<monthList.length;i++){
            outPrint.append("<td>").append(year).append("-").append(monthList[i]).append("</td>");
            outPrint.append("</tr>\n" + "  </table>\n");
        }
        out.println(outPrint.toString());
    }
}
