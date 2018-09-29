package chapter_04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author liuxin
 * @version Id: InjectConfig.java, v 0.1 2018/9/28 3:51 PM
 */
@Configuration
public class InjectConfig {


    @Bean(name = "b1")
    public B createB() {
        return new B("b1");
    }

    @Primary
    @Bean(name = "b2")
    public B createB2(){
        return new B("b2");
    }

}
