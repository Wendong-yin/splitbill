package com.zz.bill.service.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements IRedisService{

    @Autowired
    private RedisTemplate<String,String> stringStringRedisTemplate;

    @Override
    public void test(){

    }

}
