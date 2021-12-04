package cn.edu.nwpu.salarymanagementsystem.controller.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName StaffInterceptor
 * @Description 员工访问拦截器
 * @Author xuLyi
 * @Date 2021/12/1
 * @Version 1.0
 */
public class StaffInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        HttpSession session = request.getSession();
        //如果session中没有管理员信息，或者信息不对，则跳转到登录界面
        if (session.getAttribute("staff") == null) {
            request.setAttribute("message", "You don't have permission.");
            request.getRequestDispatcher("/WEB-INF/test1/sign-in.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView model)
            throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
                                Exception exception) throws Exception {
    }
}
