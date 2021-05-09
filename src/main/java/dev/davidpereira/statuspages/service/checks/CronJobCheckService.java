package dev.davidpereira.statuspages.service.checks;

import org.springframework.scheduling.TaskScheduler;

public class CronJobCheckService {

    private final TaskScheduler scheduler;

    public CronJobCheckService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

}
