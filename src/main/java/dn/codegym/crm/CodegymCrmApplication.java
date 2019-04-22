package dn.codegym.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages="dn.codegym.crm.repository")
@EnableJpaAuditing()
@SpringBootApplication
public class CodegymCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodegymCrmApplication.class, args);
    }

}
