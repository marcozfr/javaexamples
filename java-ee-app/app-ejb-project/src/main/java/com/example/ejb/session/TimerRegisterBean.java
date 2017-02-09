package com.example.ejb.session;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
@LocalBean
public class TimerRegisterBean {

    @Resource
    TimerService timerService;
    
    public void registerTimer(){
        ScheduleExpression sexp = new ScheduleExpression().second(10);
        Timer t = timerService.createCalendarTimer(sexp);
        System.out.println(t.getInfo());
    }
    
    @Timeout
    public void fireTimer(Timer timer){
        System.out.println("fire timer :");
        System.out.println(timer.getInfo());
    }
    
}
