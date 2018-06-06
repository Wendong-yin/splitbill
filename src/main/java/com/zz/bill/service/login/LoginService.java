package com.zz.bill.service.login;

import com.zz.bill.CommonCode;
import com.zz.bill.entity.account.User;
import com.zz.bill.exception.UserException;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.repo.UserRepo;
import com.zz.bill.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILogin {

    // ❤️ 这个为什么有黄线
    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public JsonResult register(UserInfo userInfo) throws Exception {
        UserInfo user = userService.addUser(userInfo);
        return JsonResult.builder()
                .code(CommonCode.SUCC.getCode())
                .msg(CommonCode.SUCC.getMessage())
                .data(user)
                .build();
    }

    @Override
    public JsonResult login(UserInfo userInfo) throws Exception {
        UserInfo user_passedin = userService.checkValidity(userInfo);
        // ❤️ 像这种只有一行的代码，用写到 UserService 层中吗？
        UserInfo user_storedinDB = userRepo.findByAccount(user_passedin.getAccount()).get(0);
        if (!user_passedin.getPassword().equals(user_storedinDB.getPassword())){
            throw new UserException(CommonCode.WRONG_PWD);
        }
        return JsonResult.builder()
                .msg(CommonCode.SUCC.getMessage())
                .code(CommonCode.SUCC.getCode())
                .data(userInfo)
                .build();
    }
}
