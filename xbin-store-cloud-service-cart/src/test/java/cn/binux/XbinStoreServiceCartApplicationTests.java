package cn.binux;

import cn.binux.cart.service.CartService;
import cn.binux.cart.service.impl.CartServiceImpl;
import cn.binux.utils.JedisClient;
import cn.binux.utils.impl.JedisClientSingle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@MapperScan(basePackages = "cn.binux.mapper")
public class XbinStoreServiceCartApplicationTests {
    @Autowired
    private CartServiceImpl cartService;

    @Test
    public void contextLoads() {
        cartService.getCartInfoListByCookiesId("abcd");
    }
    public JedisClient jedisClient() {
        return new JedisClientSingle();
    }
}
