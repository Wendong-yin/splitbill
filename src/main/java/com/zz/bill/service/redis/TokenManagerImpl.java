package com.zz.bill.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TokenManagerImpl implements ITokenManager {
    @Autowired
    private RedisTemplate<String,String> redis;


    @Override
    public String createToken(Integer userId) {
        // 使用 uuid 作为源 token
        String token = UUID.randomUUID().toString().replace("-","");

        // 存储到 redis 并设置过期时间
        // ❤️ 注意把 Integer 转化成  String 的方法
        redis.opsForValue().set(token,userId.toString(),1L,TimeUnit.HOURS);
        return token;
    }


    @Override
    public Integer getUserID(String authentication) {
        if (authentication == null || authentication.length () == 0) {
            return null;
        }

        String result = redis.opsForValue().get(authentication);
        return Integer.valueOf(result);

//        String [] param = authentication.split ("_");
//        if (param.length != 2) {
//            return null;
//        }
//        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
//        Integer userId = Integer.parseInt(param [0]);
//        String token = param [1];
//        return new TokenModel (userId, token);
    }

    @Override
    public boolean checkToken(String token) {
        if (token == null) {
            return false;
        }

        return redis.hasKey(token);
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
//        redis.boundValueOps (model.getUserId()).expire (Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
//        return true;
    }

    @Override
    public void deleteToken(Integer userId) {
        redis.delete(userId+"");

    }
}
