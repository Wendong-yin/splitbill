package com.zz.bill.service;

import com.zz.bill.entity.Result;
import com.zz.bill.entity.Share;
import com.zz.bill.entity.Spend;
import com.zz.bill.model.calculator.CalculateResult;
import com.zz.bill.model.calculator.FinalTransfer;
import com.zz.bill.repo.ResultRepo;
import com.zz.bill.service.event.IEventService;
import com.zz.bill.service.share.IShareBaseService;
import com.zz.bill.service.spend.ISpentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Autowired
    private IEventService eventService;

    @Autowired
    private ISpentBaseService spendService;

    @Autowired
    private IShareBaseService shareService;

    @Autowired
    private ResultRepo resultRepo;

    public List<CalculateResult> calculate(List<Integer> uids, Integer eventId){
        List<Spend> spends = spendService.getAllSpend(eventId);
        if (CollectionUtils.isEmpty(spends)) {
            return null;
//            return CalculatorResult.emptyResult();
        }

        CalculateResult result = new CalculateResult();

        List<Share> totalShares = new ArrayList<>();

        for (Spend spend : spends) {
            List<Share> shares = shareService.findSharesBySpendID(spend.getSpendId());
            totalShares.addAll(shares);
        }



        List<CalculateResult> finalResult = new ArrayList<>();
        for (Integer uid : uids) {

            CalculateResult currentUserResult = new CalculateResult();
            BigDecimal totalShouldPay = new BigDecimal(0);
            BigDecimal totalShouldReceive = new BigDecimal(0);
//            totalShares.stream().filter(share -> share.getUserID().intValue() == uid).forEach(share -> totalShouldPay.add(share.setShouldPay()))
            for (Share share : totalShares) {
                if(share.getUserID().intValue() == uid){
                    totalShouldPay = totalShouldPay.add(share.getShouldPay());
                    totalShouldReceive = totalShouldReceive.add(share.getShouldReceive());
                }
            }

            currentUserResult.setUid(uid);
            currentUserResult.setTotalPay(totalShouldPay);
            currentUserResult.setTotalReceive(totalShouldReceive);
            currentUserResult.setTotalResult(totalShouldPay.subtract(totalShouldReceive));
            finalResult.add(currentUserResult);
        }

        return finalResult;
    }

    @Override
    public List<Result> finalResult(List<CalculateResult> totalResult , Integer eventID) {
//        result.add(new FinalTransfer(1, 293.33));
//        result.add(new FinalTransfer(2, 93.33));
//        result.add(new FinalTransfer(3, -6.67));
//        result.add(new FinalTransfer(4, 293.33));
//        result.add(new FinalTransfer(5, -706.67));
//        result.add(new FinalTransfer(6, 33.33));

        PriorityQueue<CalculateResult> receive = new PriorityQueue<>((o1, o2) -> o1.getTotalPay().compareTo(o2.getTotalResult()));
        PriorityQueue<CalculateResult> pay = new PriorityQueue<>((o1, o2) -> o1.getTotalResult().compareTo(o2.getTotalResult()));

        List<Result> finalResult = new ArrayList<>();
        for (CalculateResult calculateResult : totalResult) {
            if(calculateResult.getTotalResult().compareTo(new BigDecimal(0)) < 0 ){
                receive.add(calculateResult);
            }else {
                pay.add(calculateResult);
            }
        }

        System.out.println(receive);
        System.out.println(pay);

        CalculateResult curPay = pay.remove();

        while(!receive.isEmpty()){
            CalculateResult curReceive= receive.remove();

            while(curReceive.getTotalResult().add(curPay.getTotalResult()).compareTo(new BigDecimal(0))<0){
                Result result1 = new Result(curPay.getUid(),curReceive.getUid(),curPay.getTotalResult());
                result1.setEventID(eventID);
                resultRepo.save(result1);
                finalResult.add(result1);

                curReceive.setTotalResult(curReceive.getTotalResult().add(curPay.getTotalResult()));
                if(!pay.isEmpty()) {
                    curPay = pay.remove();
                }else{
                    break;
                }
            }

            Result result2 = new Result(curPay.getUid(), curReceive.getUid(),curReceive.getTotalResult().abs());
            result2.setEventID(eventID);
            resultRepo.save(result2);
            finalResult.add(result2);

            curPay.setTotalResult(curPay.getTotalResult().add(curReceive.getTotalResult()));
        }
        return finalResult;
    }



//    @Override
//    public CalculatorResult calculateResult(Integer userId, Integer eventId) {
//        List<Spend> spends = spendService.getAllSpend(eventId);
//        if (CollectionUtils.isEmpty(spends)) {
//            return null;
////            return CalculatorResult.emptyResult();
//        }
//
//        CalculatorResult calculatorResult = new CalculatorResult();
//        //SpandCalculator
//
//
//        List<SpendCalculatorResult> spendCalculatorResults = spends.parallelStream()
//                .map(spend ->
//                        calculateShares(spend, shareService.findSharesBySpendID(spend.getSpendId()))
//                )
//                .collect(Collectors.toList());
//
//        spends.parallelStream().forEach(spend -> {
//            //spends.filter(userId).getPrepay().sum() total prepay
//            if (spend.getPrepayUserID().intValue() == userId) {
//                calculatorResult.getPrepay().add(calculatorResult.getPrepay().add(spend.getAmount()));
//            }
//            //total Share
//            List<Share> shares = shareService.findSharesBySpendID(spend.getSpendId();
//            shares.forEach(share -> {
//                if (spend.getPrepayUserID().intValue() != userId.intValue()) {
//                    calculatorResult.setShare(calculatorResult.getShare().add(share.getShareAmount()));
//                }
//            });
//        });
//
//        calculatorResult.setSpendResults(spendCalculatorResults);
//        return calculatorResult;
//    }
//
//    private SpendCalculatorResult calculateShares(Spend spend, List<Share> shares) {
//        SpendCalculatorResult spendCalculatorResult = new SpendCalculatorResult();
//        spendCalculatorResult.setDes(spend.getDescription());
//
////        if (spend.getPrepayUid().intValue() == uid.intValue()) {
////            spendCalculatorResult.setPrepay(spend.getAmount());
////        }else {
////            spendCalculatorResult.setPrepay(new BigDecimal("0.00"));
////        }
//        spendCalculatorResult.setPrepay(spend.getAmount());
//        spendCalculatorResult.setShare(spend.getAmount().divide(new BigDecimal(shares.size())));
//        return spendCalculatorResult;
//    }


}

