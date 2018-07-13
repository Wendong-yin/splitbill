package com.zz.bill.service.redis.token;

import com.zz.bill.BillApplicationTests;
import com.zz.bill.service.TokenManagerImpl;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenManagerImplTest extends BillApplicationTests {

    @Autowired
    TokenManagerImpl tokenmanager;





    @Test
    public void createToken() {
        String token;
        Integer id = 123;

        token = tokenmanager.createToken(id);

        Assert.assertNotNull(token);
    }

    @Test
    public void getToken() {
        String token;
        Integer id = 123;

        token = tokenmanager.createToken(id);

        Integer result = tokenmanager.getUserID(token);
        Assert.assertEquals(id,result);
    }

    @Test
    public void checkToken() {
        String token;
        Integer id = 123;

        token = tokenmanager.createToken(id);

        boolean result = tokenmanager.checkToken(token);
        Assert.assertEquals(result, true);
    }
}