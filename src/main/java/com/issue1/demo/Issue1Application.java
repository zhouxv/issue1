package com.issue1.demo;


import com.issue1.dependence.common.properties.SysProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.issue1.demo.**.mapper")
@EnableConfigurationProperties({SysProperties.class})
public class Issue1Application {

    public static void main(String[] args) {
        SpringApplication.run(Issue1Application.class, args);
    }

}
