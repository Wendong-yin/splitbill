package com.zz.bill.service.share;

import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;

import java.util.List;

public interface IShareService {
    JsonResult add(List<User> sharedUsers, Spend spend);
    JsonResult getbyshareId(Integer shareID);


}
