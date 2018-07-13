package com.zz.bill.service;

import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.repo.ShareRepo;
import com.zz.bill.util.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShareService implements IShareService {

    @Autowired
    ShareRepo shareRepo;


    // ❤️ spend 这个参数 传进来，还是从数据库中读取呢？
    // ❤ 我感觉应该是前端取平均预算之后，把计算的结果，存入数据库中。
    // 如果后端计算，那么用户可能不能得到实时的结果，存入速度很慢。
    @Override
    public JsonResult add(List<User> sharedUsers, Spend spend) {
        // TODO 需要得到活动的人数
        BigDecimal sharedNum = BigDecimal.valueOf(sharedUsers.size());
        BigDecimal avgAmout = spend.getAmount().divide(sharedNum,2,BigDecimal.ROUND_HALF_UP);

        List<Share> result = new LinkedList<>();
        for (User sharedUser : sharedUsers) {
            Share share = Share.builder()
                    .spendID(spend.getSpendId())
                    .shareID(sharedUser.getUid())
                    .amount(avgAmout)
                    .build();
            result.add(shareRepo.save(share));

        }

        return JsonResult.createBySuccess(result);

    }

    @Override
    public JsonResult getbyshareId(Integer shareID) {
        return null;
    }
}
