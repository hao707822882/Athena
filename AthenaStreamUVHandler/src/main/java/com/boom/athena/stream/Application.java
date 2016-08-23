package com.boom.athena.stream;
/**
 * Created by Administrator on 2016/8/9.
 */

import com.boom.base.RedisService;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/9
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boom.athena")
public class Application {

    @Bean
    public RabbitAdmin rabbitAdmin(@Autowired ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RedisService redisService(@Autowired StringRedisTemplate stringRedisTemplate) {
        RedisService redisService = new RedisService();
        redisService.setStringRedisTemplate(stringRedisTemplate);
        return redisService;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
        System.in.read();
    }
}
