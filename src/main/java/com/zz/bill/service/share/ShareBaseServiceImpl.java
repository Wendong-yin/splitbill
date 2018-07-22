package com.zz.bill.service.share;

import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.repo.ShareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class ShareBaseServiceImpl implements IShareBaseService {

    @Autowired
    ShareRepo shareRepo;


    // ❤️ spend 这个参数 传进来，还是从数据库中读取呢？
    // ❤ 我感觉应该是前端取平均预算之后，把计算的结果，存入数据库中。
    // 如果后端计算，那么用户可能不能得到实时的结果，存入速度很慢。
    @Override
    public List<Share> add(List<Integer> uid, Spend spend) {
        // TODO 需要得到活动的人数
        BigDecimal sharedNum = BigDecimal.valueOf(uid.size());
        BigDecimal avgAmout = spend.getAmount().divide(sharedNum,2,BigDecimal.ROUND_HALF_UP);

        List<Share> result = new LinkedList<>();
        for (Integer user: uid) {
            Share share = Share.builder()
                    .spendID(spend.getSpendId())
                    .userID(user)
                    .amount(avgAmout)
                    .build();
            if(spend.getPrepayUserID().intValue() == user){
                share.setShouldReceive(spend.getAmount().subtract(avgAmout));
                share.setShouldPay(new BigDecimal(0));
            }else{
                share.setShouldPay(avgAmout);
                share.setShouldReceive(new BigDecimal(0));
            }

            result.add(shareRepo.save(share));
        }

        return result;
    }

    @Override
    public Share getbyshareId(Integer shareID) {
        return shareRepo.getOne(shareID);
    }
}
