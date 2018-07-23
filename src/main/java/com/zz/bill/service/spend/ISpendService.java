package com.zz.bill.service.spend;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;

import java.util.List;

public interface ISpendService {
    JsonResult createSpend (Spend spend);

    JsonResult getOneSpend(Integer spendID);

    JsonResult getAllSpend(Integer eventID);
    
}
