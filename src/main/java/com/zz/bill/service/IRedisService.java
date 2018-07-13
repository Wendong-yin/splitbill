package com.zz.bill.service;

public interface IRedisService {
    void test();

    /**
     *
     * @param userid
     * @return userToken based on time
     */
    String createToken(String userid);


    /**
     *
     * @param authToken
     * @return userid
     */
    String checkToken(String authToken);
}
