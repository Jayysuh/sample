package com.perscholas.GLAB309_5_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    localhost:8080/actuator/health: UP = It means that the application is healthy
        and running without any interruption.
    localhost:8080/actuator/metrics = To view the application metrics such as memory used, memory
        free, threads, classes, system uptime etc.
    localhost:8080/actuator/env = To view the list of environment variables used in the application.
    localhost:8080/actuator/beans = To view the spring beans and their types, scopes, and dependencies,
    localhost:8080/actuator/info = To view the information about the Spring Boot application.
 */
@RestController
public class DemoController {
    @GetMapping("/get-info")
    public String getStringMessage() {
        return "Hi ! You will be able to monitor the health of the application !!" ;
    }
}
