package com.example.backendv1;

import com.example.backendv1.Config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        FileStorageProperties.class
})
@SpringBootApplication
public class BackendV1Application {
    public static void main(String[] args) {
        SpringApplication.run(BackendV1Application.class, args);
    }

}
