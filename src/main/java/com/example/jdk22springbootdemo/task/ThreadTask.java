package com.example.jdk22springbootdemo.task;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

/**
 * @author huangji
 * @version 1.0
 **/
@Component
public class ThreadTask {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ExecutorService virtualThreadPoolExecutor;

    //    @Scheduled(cron = "*/30 * * * * ?")
    @PostConstruct
    public void doTask() {
        IntStream.range(0, 10_000).forEach(i -> {
            virtualThreadPoolExecutor.submit(() -> {
                log.info(String.valueOf(Thread.currentThread()));
            });
        });
    }
}
