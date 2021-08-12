package com.wx.pay.wx_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableOpenApi
@SpringBootApplication
public class WxDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WxDemoApplication.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(WxDemoApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application wx_demo is running! Access URLs:\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + "/swagger-ui/\n" +
                "----------------------------------------------------------");
    }

}
