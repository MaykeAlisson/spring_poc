package br.com.mayke.studyspring.service.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@Configuration
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

    @Scheduled(cron = "${service.scheduler.cron}", zone = "${service.scheduler.time-zone}")
    public void process(){
        log.info("SchedulerServiceImpl.process() - start , now {}", LocalDateTime.now());
        System.out.println("realizar algum processamento");
        log.info("SchedulerServiceImpl.process() - end , now {}", LocalDateTime.now());
    }
}
