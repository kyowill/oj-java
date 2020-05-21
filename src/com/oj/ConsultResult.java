package com.oj;


import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class ConsultResult {


    public ConsultResult(boolean isEnable, String errorCode) {
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    /**
     * 咨询结果是否可用
     */
    private boolean isEnable;

    /**
     * 错误码
     */
    private String errorCode;
    private static Map<String, Boolean> map =  new ConcurrentHashMap<>();
    private static Timer timer = new Timer();
    static {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //rpc支付宝获取可用状态
                ConsultResult.map.put("alipay", true);
                //rpc余额宝
                ConsultResult.map.put("余额宝", true);
            }
        };
        timer.schedule(task, 10000);
    }
    public boolean getIsEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public boolean isEnable(String paymentType) {
        return ConsultResult.map.get(paymentType);
    }
}