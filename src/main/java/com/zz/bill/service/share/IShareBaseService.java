package com.zz.bill.service.share;

import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;

import java.util.List;

public interface IShareBaseService {
    List<Share> add(List<Integer> sharedUsers, Spend spend);
    Share getbyshareId(Integer shareID);
    List<Share> findSharesBySpendID(Integer SpendID);


}
