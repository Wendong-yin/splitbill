package com.zz.bill.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements IRedisService{

    @Autowired
    private RedisTemplate<String,String> StringRedisTemplate;

    @Override
    public void test(){

    }

    @Override
    public String createToken(String userid) {
        return null;
    }

    @Override
    public String checkToken(String authToken) {
        return null;
    }

}
