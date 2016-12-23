package org.shiki.tsframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// import java.util.Arrays;

/**
 * Created by tsujishiki on 2016/10/31.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");

        // ApplicationContext ctx =
                SpringApplication.run(Application.class, args);

        /*
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
         */
    }

}
