package com.zz.bill.service.event;

import com.zz.bill.entity.Event;
import com.zz.bill.entity.User;

import java.util.List;

public interface EventBaseService {
    // 对 Event 本身的操作
    Event creatEvent(Event event);

    Event updateEventName(Event event);

    List<Event> getEventsByUID(Integer UID);
    Event getEventByEventID(Integer eventid);

    boolean deleteEvent(Integer eventID);

    // 对 Event 和 User 关系的操作

    List<User> addUser(Integer eventID, Integer userID);

    List<User> getEventUsers(Integer eventID);


}
