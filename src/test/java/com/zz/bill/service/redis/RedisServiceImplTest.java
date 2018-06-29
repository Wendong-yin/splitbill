package com.zz.bill.service.redis;

import com.zz.bill.BillApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class RedisServiceImplTest extends BillApplicationTests {

    @Autowired
    private RedisTemplate<String,String> stringRedisTemplate;

    @Test
    public void test1() throws  Exception{
        String userToken = "XXXX-mmm-nnn";
        String userId = "0029204647";
        stringRedisTemplate.opsForValue().set(userToken,userId,2L,TimeUnit.MINUTES);

        // 判断用户的 token 是否有效
        Boolean hasKey = stringRedisTemplate.hasKey(userToken);

        // 如果有效，通过 token 拿到用户的 id
        String data = stringRedisTemplate.opsForValue().get(userToken);
        Assert.assertEquals(data,userId);

        // 统计频率
        Long inc = stringRedisTemplate.opsForValue().increment("freq",1);
        System.out.println(inc);

        // Ops for hash

        String name = "HJY";
        String gender = "male";
        String age = "18";
        stringRedisTemplate.opsForHash().put(name,"gender",gender);
        stringRedisTemplate.opsForHash().put(name,"age",age);
        String queryAge = (String) stringRedisTemplate.opsForHash().get(name,"age");
        Assert.assertEquals(age,queryAge);

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(name);
        for (Object key : entries.keySet()) {
            System.out.println((String) entries.get(key));
        }

        //stringRedisTemplate.opsForList().



    }
}