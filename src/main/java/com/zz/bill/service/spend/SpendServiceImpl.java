package com.zz.bill.service.spend;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendServiceImpl implements ISpendService {

    @Autowired
    ISpentBaseService spentBaseService;
    @Override
    public JsonResult createSpend(Spend spend) {
        Spend spend1 = spentBaseService.createSpend(spend);
        return JsonResult.createBySuccess(spend1);
    }

    @Override
    public JsonResult getOneSpend(Integer spendID) {
        return JsonResult.createBySuccess(spentBaseService.getOneSpend(spendID));
    }

    @Override
    public JsonResult getAllSpend(Integer eventID) {
        List<Spend> allSpend = spentBaseService.getAllSpend(eventID);

        return JsonResult.createBySuccess(allSpend);
    }
}
