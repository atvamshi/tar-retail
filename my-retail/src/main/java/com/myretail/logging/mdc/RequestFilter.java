package com.myretail.logging.mdc;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Project: myretail-parent
 * Package: com.myretail.logging.mdc
 * <p>
 * User: vthalapu
 * Date: 4/20/18
 * Time: 8:17 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // Setup MDC data:
//            String mdcData = String.format("[userId:%s | requestId:%s] ", user(), requestId());
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession();

            String mdcData = session.getId();
            MDC.put("mdcData", mdcData); //Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
            chain.doFilter(request, response);
        } finally {
            // Tear down MDC data:
            // ( Important! Cleans up the ThreadLocal data again )
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}