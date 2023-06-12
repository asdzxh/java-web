//package top.zxh.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//import java.util.logging.LogRecord;
//
///**
// * Date:2023/3/5
// * Author：zxh
// * Description: 实现 Filter 接口
// */
//@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
//public class FilterDemo implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Filter被执行了");
//        //放行，放请求访问其本该访问的资源
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("Filter销毁了");
//
//    }
//}
