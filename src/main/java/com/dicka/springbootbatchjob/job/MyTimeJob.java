package com.dicka.springbootbatchjob.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyTimeJob {

    public MyTimeJob(){}

    /**
     *  job example, dapat di execute dalam satuan :
     *  1. detik
     *  2. menit
     *  3. jam
     *  4. hari
     *  5. mingguan
     *  6. bulanan
     *  7. bahkan custom hari
     */
    @Scheduled(cron = "* * * * * *")
    public void display(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
    }
}
