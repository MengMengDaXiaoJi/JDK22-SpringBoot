package com.example.jdk22springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author huangji
 * @version 1.0
 **/
@Configuration
@EnableAsync
public class VirtualExecutorConfig {
    @Bean
    public ExecutorService virtualThreadPoolExecutor() {
        ThreadFactory factory = Thread.ofVirtual().name("virtual-thread-test-", 0).factory();
        return Executors.newThreadPerTaskExecutor(factory);
    }
}
