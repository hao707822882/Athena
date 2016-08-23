package com.boom.athena;
/**
 * Created by Administrator on 2016/8/9.
 */

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/9
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"com.boom.athena.esdao.EventESDao"})
@ComponentScan(basePackages = "com.boom.athena")
//@ImportResource(value = {"classpath:META-INF/spring/boom-wiki-provider.xml"})
public class Application {

    @Bean
    public RabbitAdmin rabbitAdmin(@Autowired ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
        System.in.read();
    }
}
