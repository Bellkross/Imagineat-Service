package com.bellkross.imangineat;

import com.bellkross.imangineat.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ImangineatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImangineatApplication.class, args);
    }

}
