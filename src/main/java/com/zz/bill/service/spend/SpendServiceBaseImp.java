package com.zz.bill.service.spend;

import com.zz.bill.util.CommonCode;
import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import com.zz.bill.repo.SpendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendServiceBaseImp implements ISpentBaseService {

    @Autowired
    SpendRepo spendRepo;

    @Override
    public Spend createSpend(Spend spend) {


        // TODO 判断 eventID 是否存在
        //

        // 如果 eventID 存在

        // TODO 判断prePay User 是否和 spend 相关联

        // 如果关联
        //      spendRepo.save(spend);

        return spendRepo.save(spend);
    }

    @Override
    public Spend getOneSpend(Integer spendID) {
        // TODO 查找失败怎么办
        Spend result = spendRepo.findOne(spendID);
        if (result == null){
            return null;
        }
        return result;

    }

    @Override
    public List<Spend> getAllSpend(Integer eventID) {
        return spendRepo.findByeventId(eventID);
    }
}
