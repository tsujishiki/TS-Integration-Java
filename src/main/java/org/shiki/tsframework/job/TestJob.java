package org.shiki.tsframework.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by tsujishiki on 2016/12/8.
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component
public class TestJob extends QuartzJobBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        System.out.println(name);

    }
}
