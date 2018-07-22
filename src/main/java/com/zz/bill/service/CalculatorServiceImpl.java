//package com.zz.bill.service;
//
//import com.zz.bill.entity.Spend;
//import com.zz.bill.model.CalculatorResult;
//import com.zz.bill.service.event.IEventService;
//import com.zz.bill.service.share.IShareService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//
//public class CalculatorServiceImpl implements ICalculatorService {
//
//    @Autowired
//    private IEventService eventService;
//
//    @Autowired
//    private ISpentService spentService;
//
//    @Autowired
//    private IShareService shareService;
//    @Override
//    public CalculatorResult calculateResult(Integer userID, Integer eventId) {
//        List<Spend> spends = spentService.getOneSpend(eventId);
//
//        if(CollectionUtils.isEmpty(spends)){
//
//        }
//
//        CalculatorResult calculatorResult = new CalculatorResult();
//        spends.parallelStream().forEach(spend -> {
//            calculatorResult.getPrepay().add(calculatorResult.getPrepay().add(spend.getAmount()));
//
//        });
//        return null;
//    }
//}
