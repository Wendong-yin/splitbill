package com.zz.bill.service.event;

import com.zz.bill.entity.Event;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.util.EventCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    EventBaseService eventBaseService;
    @Override
    public JsonResult getEventUsers(Integer eventID) {
        List<User> result = eventBaseService.getEventUsers(eventID);
        return JsonResult.createBySuccess(result);
    }

    public JsonResult creatEvent(Event event){
       Event result = eventBaseService.creatEvent(event);
       return JsonResult.createBySuccess(result);
    }

    public JsonResult addUser(Integer eventID, Integer userID){
        List<User> users = eventBaseService.addUser(eventID, userID);
        return JsonResult.createBySuccess(users);
    }

    public JsonResult getEventbyEventID(Integer eventId){
        Event event = eventBaseService.getEventByEventID(eventId);
        if(event == null){
            return JsonResult.createByErrorMsg(EventCode.EVENTNOTEXIST.getMsg());
        }
        return JsonResult.createBySuccess(event);
    }
}
