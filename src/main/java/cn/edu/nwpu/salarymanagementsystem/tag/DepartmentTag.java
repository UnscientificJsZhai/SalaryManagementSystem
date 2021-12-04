package cn.edu.nwpu.salarymanagementsystem.tag;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentTag extends SimpleTagSupport {

    private ArrayList<DepartmentTreeNode> treeNodes;

    public void setTreeNodes(ArrayList<DepartmentTreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        try {
            StringBuilder outPrint = new StringBuilder();
            for (DepartmentTreeNode treeNode : treeNodes) {
                traverse(treeNode, outPrint);
                outPrint.append("<br/>");
            }
            out.println(outPrint.toString());
        } catch (NullPointerException e) {
            out.println();
        }
    }

    public void traverse(DepartmentTreeNode departmentTreeNode, StringBuilder str) {
        MutableDepartment department = departmentTreeNode.getData();
        int level = department.getLevel();
        str.append("--".repeat(Math.max(0, level - 1)))
                .append(department.getName())
                .append("<a href=\"/Admin/editDepartment/")
                .append(department.getId())
                .append("\">edit</a>")
                .append("<a href=\"/Admin/deleteDepartment/")
                .append(department.getId())
                .append("\">delete</a>")
                .append("<br/>");
        for (DepartmentTreeNode node : departmentTreeNode
        ) {
            traverse(node, str);
        }
    }

}
