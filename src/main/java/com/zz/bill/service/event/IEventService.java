package com.zz.bill.service.event;

import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;

import java.util.List;

public interface IEventService {
    JsonResult getEventUsers(Integer eventID);
}
