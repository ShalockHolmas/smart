package cn.felixgu.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableDiscoveryClient
public class CloudConfigApplication {

    public static final Logger logger = LoggerFactory.getLogger(CloudConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class, args);
    }
}
