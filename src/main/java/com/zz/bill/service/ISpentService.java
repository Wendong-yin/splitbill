package com.zz.bill.service;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;

public interface ISpentService {



    JsonResult createSpend (Spend spend);

    JsonResult getOneSpend(Integer spendID);

    JsonResult getAllSpend(Integer eventID);

}
