package com.zz.bill.service.user.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void checkUserExist() {
        boolean result = userService.checkUserExist(1);
        Assert.assertEquals(true, result);
    }

    @Test
    public void checkAccountNameExist() {
        boolean result = userService.checkAccountNameExist("wendong");
        boolean result2 = userService.checkAccountNameExist("wendongggg");
        Assert.assertEquals( true,result);
        Assert.assertEquals(false, result2);
    }
}