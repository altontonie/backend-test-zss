package backyard.programmer.backendtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class BackendTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendTestApplication.class, args);
    }

}
