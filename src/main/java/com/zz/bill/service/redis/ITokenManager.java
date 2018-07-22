package com.zz.bill.service.redis;


public interface ITokenManager {

    /**
     * 创建一个 token 关联上指定用户
     * @param userId 指定用户的 id
     * @return 生成的 token
     */
    public String createToken (Integer userId);



    /**
     * 检查 token 是否有效
     * @param  token
     * @return 是否有效
     */
    public boolean checkToken (String token);


    /**
     * 加密后的字符串
     * @param token
     * @return
     */
    public Integer getUserID(String token);



    /**
     * 清除 token
     * @param userId 登录用户的 id
     */
    public void deleteToken (Integer userId);

}
