package com.dicka.springbootbatchjob.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ConfigJob implements SchedulingConfigurer {

    @Value("${spring.job}")
    private String threadNamePrefix;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTask = new ThreadPoolTaskScheduler();
        threadPoolTask.setPoolSize(10);
        threadPoolTask.setThreadNamePrefix(threadNamePrefix);
        threadPoolTask.initialize();
        scheduledTaskRegistrar.setTaskScheduler(threadPoolTask);
    }
}
