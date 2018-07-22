package com.zz.bill.service.share;

import com.zz.bill.model.JsonResult;

import java.util.List;

public interface IShareService {

    JsonResult addShare(List<Integer> uid, Integer spendID);

}
