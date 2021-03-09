package com.springcloud.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class MyFilter extends ZuulFilter {
    private Logger log = LoggerFactory.getLogger(MyFilter.class);

    private final String PRE_TYPE = "pre";
    private final String ROUTINT_TYPE = "routing";
    private final String POST_TYPE = "post";
    private final String ERROR_TYPE = "error";
    @Override
    public String filterType() {//过滤器类型
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {//过滤器执行顺序，越小越优先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {//是否执行，true执行run方法，false不执行
        return true;
    }

    @Override
    public Object run() {//过滤器逻辑
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getParameter("token");
        if(accessToken==null || "".equals(accessToken)){
            log.error("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().println("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("ok");
        return null;
    }
}

