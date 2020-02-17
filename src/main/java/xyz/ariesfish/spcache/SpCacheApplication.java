package xyz.ariesfish.spcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("xyz.ariesfish.spcache.mapper")
@SpringBootApplication
@EnableCaching
public class SpCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpCacheApplication.class, args);
    }

}
