package org.shiki.tsframework.config;

import org.shiki.tsframework.factory.AutoWiringSpringBeanJobFactory;
import org.shiki.tsframework.job.TestJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tsujishiki on 2016/12/8.
 */
@Configuration
public class QuartzConfig {

    @Bean
    public AutoWiringSpringBeanJobFactory autoWiringSpringBeanJobFactory() {
        return new AutoWiringSpringBeanJobFactory();
    }

    @Bean(name = "job1")
    public JobDetailFactoryBean jobDetailFactoryBean1() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(TestJob.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mealtype", "1");
        factory.setJobDataAsMap(map);
        factory.setGroup("mygroup");
        factory.setName("myjob1");
        return factory;
    }

    @Bean(name = "cron1")
    public CronTriggerFactoryBean cronTriggerFactoryBean1() {
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(jobDetailFactoryBean1().getObject());
        stFactory.setStartDelay(3000);
        stFactory.setName("mytrigger1");
        stFactory.setGroup("mygroup");
        stFactory.setCronExpression("0 1/1 0/1 * * ? *");
        System.out.print("Trigger1 job time: " + "0 1/1 0/1 * * ? *");
        return stFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(autoWiringSpringBeanJobFactory());
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean1().getObject());
        return schedulerFactoryBean;
    }
}
