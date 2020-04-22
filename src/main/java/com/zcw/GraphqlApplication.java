package com.zcw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.zcw"})
@EnableTransactionManagement(proxyTargetClass = true)
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication  app  = new SpringApplication(GraphqlApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("GraphqlApplication start  successfully!");
    }
}
