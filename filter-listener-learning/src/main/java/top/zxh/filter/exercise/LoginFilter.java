package top.zxh.filter.exercise;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Date:2023/3/6
 * Author：zxh
 * Description: 登录过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter初始化");    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //登录状态校验逻辑代码
        //0.将ServletRequest对象强制转换为HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1.判断访问资源路径
        //1.1在数组中存储需要放行的资源路径
        String[] urls = {"/login.jsp","/login","/css/"};
        //1.2获取当前访问的资源路径
        String url = request.getRequestURI().toString();
        //1.3 遍历数组，获取到每一个需要放行的资源路径
        for (String u : urls){
            //1.4 判断当前访问的资源路径，是否包含要放行的资源路径
            if (url.equals(u)){
                //放行
                filterChain.doFilter(request,servletResponse);
                return;
            }
        }

        //2.取出Session，并取出user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);

        //判断user是否为null
        if (user != null){
            //登录了，放行
            filterChain.doFilter(request,servletResponse);
        }else {
            //没有登录，直接跳到登录界面
            String msg = "当前用户没有登录";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("login.jsp").forward(request,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter销毁");
    }
}


