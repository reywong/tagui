package com.reywong.tool.tagui.business.framework.filter;

import com.yxtc.framework.platform.pojo.framework.UserInfoBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangrui on 2016/3/14.
 */
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 不过滤的uri
        String[] notFilter = new String[]{"/resources", "/dwr", "/demo", "/userLoginAction/toLogin", "/userLoginAction/login", "/pages/login.jsp"};

        // 请求的uri
        String uri = request.getRequestURI();
        // 是否过滤
        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.indexOf(s) != -1) {
                // 如果uri中包含不过滤的uri，则不进行过滤
                doFilter = false;
                break;
            }
        }

        if (doFilter) {
            // 执行过滤
            // 从session中获取登录者实体
            UserInfoBean userInfoBean = (UserInfoBean) request.getSession().getAttribute("userInfoBean");
            if (null == userInfoBean) {
                boolean isAjaxRequest = isAjaxRequest(request);
                if (isAjaxRequest) {
                    response.setCharacterEncoding("UTF-8");
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
                    return;
                }
                String url = request.getRequestURI();
                if (!url.equals("/")) {
                    request.getSession().setAttribute("url", url);
                } else {
                    request.getSession().setAttribute("url", "/userLoginAction/login");
                }
                response.sendRedirect("/userLoginAction/toLogin");
                return;
            } else {
                // 如果session中存在登录者实体，则继续
                filterChain.doFilter(request, response);
            }
        } else {
//            如果不执行过滤，则继续
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 判断是否为Ajax请求
     * <功能详细描述>
     *
     * @param request
     * @return 是true, 否false
     * @see [类、类#方法、类#成员]
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header))
            return true;
        else
            return false;
    }


}
