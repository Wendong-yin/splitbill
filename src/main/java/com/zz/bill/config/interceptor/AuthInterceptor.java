package com.zz.bill.config.interceptor;

import com.zz.bill.CommonCode;
import com.zz.bill.config.Token;
import com.zz.bill.entity.account.User;
import com.zz.bill.exception.UserException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final String AUTH_HEADER = "X-Auth";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AUTH_HEADER);

        // ❤️ 如果获取用户名呢？
        // TODO token 验证
        if (token.equals(Token.Tom.getToken()))
        {
            return true;
        }else{
            throw new UserException(CommonCode.AUTH_FORBIDDEN);
        }
    }
    // 返回 true ，系统认为是 okay 的，可以继续运行
    // 返回 false，会出问题

}
