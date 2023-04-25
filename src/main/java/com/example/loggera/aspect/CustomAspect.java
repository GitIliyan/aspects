package com.example.loggera.aspect;

import com.example.loggera.entities.TestObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.sql.Join;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.logging.Logger;
@Aspect
@Component
public class CustomAspect {
    @AfterReturning(pointcut = "execution(* com.example.loggera.controllers.Controller.*(..))",returning = "hui")
    public void afterReturn(JoinPoint joinPoint, ResponseEntity<String> hui){
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(hui);
        String url = "http://192.168.100.37:8080/server/process/" + hui.toString();
        System.out.println(url);
        HttpMethod method = HttpMethod.GET;
        ResponseEntity<String> response = restTemplate.exchange(url, method, null, String.class);

    }
}