package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 * @author
 */
@Slf4j
@Component
public class MyFilter extends ZuulFilter {

    /**
     * 过滤类型:
     * pre     路由前
     * routing 路由时
     * post    路由后
     * error   发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * true 过滤，
     * 可以自己实现业务判断是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的业务实现
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("%s -> %s", request.getMethod(), request.getRequestURI());
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            log.error("request token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("request token is empty");
            } catch (Exception e) {
                log.warn("error e:{}", e.getMessage());
            }
        }

        return null;
    }
}
