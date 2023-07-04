package com.tx.cai.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;


/**
 * Hello world!
 *
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@PropertySource(value = {"classpath:application.yml"})
public class EurekaProvider
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaProvider.class,args);
        System.out.println( "Hello World!" );
    }
}
