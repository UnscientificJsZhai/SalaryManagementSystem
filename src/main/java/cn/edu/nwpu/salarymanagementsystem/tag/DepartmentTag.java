package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        ArrayList<DepartmentTreeNode> treeNodes = null;
        try {
            treeNodes = new AdministratorService().getDepartmentTree();
            StringBuilder outPrint = new StringBuilder();
            for (DepartmentTreeNode treeNode : treeNodes) {
                outPrint.append(traverse(treeNode));
            }
            out.println(outPrint.toString());
        } catch (DepartmentTreeException | NullPointerException e) {
            out.println();
        }

    }

    public String traverse(DepartmentTreeNode departmentTreeNode) {

        StringBuilder outPrint = new StringBuilder("");
        outPrint.append(departmentTreeNode.getData().getId()).append("\t")
                .append(departmentTreeNode.getData().getName()).append("\t")
                .append(departmentTreeNode.getData().getParentDepartment()).append("\t")
                .append(departmentTreeNode.getData().getLevel()).append("\t")
                .append("<a name=\"del\" href=\"#?departmentId=${department.id}\">删除</a>").append("\t")
                .append("<a href=\"/administrator/editDepartment?departmentId=${department.id}\">修改</a>");
        outPrint.append("<hr>");
        for (DepartmentTreeNode node : departmentTreeNode) {
            outPrint.append("\t\t");
            outPrint.append(traverse(departmentTreeNode));
        }

        return outPrint.toString();
    }

}
