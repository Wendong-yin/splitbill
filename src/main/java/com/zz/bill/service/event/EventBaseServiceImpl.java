package com.zz.bill.service.event;

import com.zz.bill.entity.Event;
import com.zz.bill.entity.EventUsersRel;
import com.zz.bill.entity.User;
import com.zz.bill.exception.EventException;
import com.zz.bill.repo.EventRepo;
import com.zz.bill.repo.EventUserRelRepo;
import com.zz.bill.repo.UserRepo;
import com.zz.bill.util.EventCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class EventBaseServiceImpl implements EventBaseService{

    @Autowired
    EventRepo eventRepo;

    @Autowired
    EventUserRelRepo eventUserRelRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Event creatEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event updateEventName(Event event) {
        Event oldEvent = eventRepo.getOne(event.getId());
        oldEvent.setEventName(event.getEventName());
        return eventRepo.save(oldEvent);
    }

    @Override
    public List<Event> getEventsByUID(Integer UID) {
        return eventRepo.findBycreatorUid(UID);
    }

    @Override
    public Event getEventByEventID(Integer eventid) {
        // TODO ❤ 查找失败如何处理
        Event event = eventRepo.getOne(eventid);
        if (event.getId() == null){
            return null;

        }else{
            return event;
        }
    }

    @Override
    public boolean deleteEvent(Integer eventID) {
        if(eventRepo.getOne(eventID) != null){
            eventRepo.delete(eventID);
            return true;
        }
        return false;
    }

    @Override
    public List<User> addUser(Integer eventID, Integer userID) {
        if(checkUserinEvent(eventID,userID) == false){
            throw new EventException(EventCode.USEREXISTSINEVENT);
        }
        EventUsersRel eventUsersRel = new EventUsersRel(eventID,userID);
        eventUserRelRepo.save(eventUsersRel);
        return getEventUsers(eventID);
    }

    public boolean checkUserinEvent(Integer eventID, Integer userID){
        List<EventUsersRel> uidList =  eventUserRelRepo.findByEventID(eventID);
        for (EventUsersRel eventUsersRel : uidList) {
            Integer uid = eventUsersRel.getUid() ;
            if(userID == uid){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<User> getEventUsers(Integer eventID) {
        List<EventUsersRel> uidList =  eventUserRelRepo.findByEventID(eventID);
        List<User> userList = new LinkedList<>();
        for (EventUsersRel eventUsersRel : uidList) {
            Integer uid = eventUsersRel.getUid() ;
            User user = userRepo.getOne(uid);
            userList.add(user);
        }
        return userList;
    }
}
