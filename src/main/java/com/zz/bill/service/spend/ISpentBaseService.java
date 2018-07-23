package com.zz.bill.service.spend;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;

import java.util.List;

public interface ISpentBaseService {

    Spend createSpend (Spend spend);

    Spend getOneSpend(Integer spendID);

    List<Spend> getAllSpend(Integer eventID);

}
