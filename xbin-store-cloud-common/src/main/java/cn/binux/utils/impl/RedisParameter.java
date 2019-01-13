package cn.binux.utils.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RedisParameter {
    @Value("${redis.single-host}")
    private String redisHost;
    @Value("${redis.single-port}")
    private int redisPort;
//    @Value("${redis.password}")
//    private String redisPassword;
}
