package com.fc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
//@Component
// 指定注入到容器中的顺序，数值越大，优先级越低
//@Order(2)
public class RichFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤前：只有有钱");

        chain.doFilter(request, response);

        System.out.println("过滤后：很有钱");
    }
}
