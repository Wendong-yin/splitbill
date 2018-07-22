package com.zz.bill.service.share;

import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import com.zz.bill.repo.SpendRepo;
import com.zz.bill.service.spend.ISpentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements IShareService{

    @Autowired
    IShareBaseService shareBaseService;

    @Autowired
    SpendRepo spendRepo;


    @Override
    public JsonResult addShare(List<Integer> uid, Integer spendID) {


        Spend spend = spendRepo.getOne(spendID);

        List<Share> shares = shareBaseService.add(uid, spend);

        return JsonResult.createBySuccess(shares);
    }
}
