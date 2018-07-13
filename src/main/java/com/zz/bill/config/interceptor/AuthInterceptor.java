package com.zz.bill.config.interceptor;

import com.zz.bill.CommonCode;
import com.zz.bill.entity.User;
import com.zz.bill.exception.UserException;
import com.zz.bill.repo.UserRepo;
import com.zz.bill.service.redis.token.TokenManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final String AUTH_HEADER = "X-Auth";

    @Autowired
    private TokenManagerImpl manager;

    @Autowired
    private UserRepo repo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String authorization = request.getHeader(AUTH_HEADER);

        // 验证 token
        if (!manager.checkToken(authorization)) {
            throw new UserException(CommonCode.AUTH_FORBIDDEN);
        }

        // 用 token 换取用户
        Integer userId = manager.getUserID(authorization);
        User user = repo.findOne(userId);
        System.out.println(user.getAccount());

        return true;
    }


}
