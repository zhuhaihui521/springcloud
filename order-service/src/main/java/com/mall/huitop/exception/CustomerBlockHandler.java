package com.mall.huitop.exception;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.mall.huitop.common.Result;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomerBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        Result responseDate = null;
        if (e instanceof FlowException) {
            responseDate = Result.ofFail(-1, "当前访问人数过多");
        } else if (e instanceof DegradeException) {
            responseDate = Result.ofFail(-2, "接口被降级了");
        } else if (e instanceof ParamFlowException) {
            responseDate = Result.ofFail(-2, "接口被热点限流了");
        } else if (e instanceof AuthorityException) {
            responseDate = Result.ofFail(-2, "接口被授权规则限制访问了");
        } else if (e instanceof SystemBlockException) {
            responseDate = Result.ofFail(-2, "接口被系统规则限制了了");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(responseDate));
    }
}
