package chapter_01;

import entities.HelloWorld;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author liuxin
 * @version Id: BeanConfig.java, v 0.1 2018/9/25 下午4:57
 */
@Configuration
public class BeanConfig {

    @Lazy(value = false)
    @Bean(name = {"hw","helloWorld"},autowire = Autowire.BY_NAME,initMethod = "initMethod",destroyMethod = "destroy")
    public HelloWorld helloWorld(){
        return new HelloWorld("@Bean注解创建");
    }
}
