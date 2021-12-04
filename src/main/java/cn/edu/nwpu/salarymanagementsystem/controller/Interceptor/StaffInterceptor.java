package cn.edu.nwpu.salarymanagementsystem.controller.Interceptor;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 员工相关URL拦截器。
 *
 * @Author xuLyi
 */
public class StaffInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object arg2) throws Exception {
        HttpSession session = request.getSession();
        // 如果session中没有管理员信息，或者信息不对，则跳转到登录界面
        if (session.getAttribute("staff") == null) {
            request.setAttribute("message", "You don't have permission.");
            request.getRequestDispatcher("/WEB-INF/test1/sign-in.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object obj, ModelAndView model) {
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object obj,
                                Exception exception) {
    }
}
