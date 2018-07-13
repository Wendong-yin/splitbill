package com.zz.bill.service.spend;

import com.zz.bill.CommonCode;
import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import com.zz.bill.repo.SpendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendServiceImp implements ISpentService {

    @Autowired
    SpendRepo spendRepo;

    @Override
    public JsonResult createSpend(Spend spend) {


        // TODO 判断 eventID 是否存在

        //

        // 如果 eventID 存在


        // TODO 判断prePay User 是否和 spend 相关联

        // 如果关联
//      spendRepo.save(spend);



        return JsonResult.builder().msg(CommonCode.SUCC.getMessage())
                .code(CommonCode.SUCC.getCode())
                .data(spendRepo.save(spend))
                .build();
    }
}
