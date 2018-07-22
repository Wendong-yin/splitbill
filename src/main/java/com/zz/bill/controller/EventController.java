package com.zz.bill.controller;

import com.zz.bill.entity.Event;
import com.zz.bill.entity.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.service.event.EventBaseServiceImpl;
import com.zz.bill.service.event.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController {


    @Autowired
    EventServiceImpl eventService;


//  👮 不要写成这样子 @PostMapping("value = /createEvent")
    @PostMapping(value= "/createEvent")
    public JsonResult createEvent(@RequestBody  Event event){
        return eventService.creatEvent(event);

    }

    @PostMapping("/addUser")
    public JsonResult addUser(@RequestParam Integer eventId, @RequestParam Integer uid){
        return eventService.addUser(eventId, uid);
    }

    @GetMapping("/getUsers")
    public JsonResult getUsers(@RequestParam Integer eventId){
        return eventService.getEventUsers(eventId);
    }

    @GetMapping("/getEvent")
    public JsonResult getEvent(@RequestParam Integer eventId){
        return eventService.getEventbyEventID(eventId);
    }

}
