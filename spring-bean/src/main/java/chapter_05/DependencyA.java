package chapter_05;

import org.springframework.stereotype.Component;
import utils.Console;

/**
 * 当构造中出现循环依赖情况会报错
 * @author liuxin
 * @version Id: DependencyA.java, v 0.1 2018/7/5 上午10:16
 */
@Component
public class DependencyA {

    public void a(String name) {
        System.out.println("dependencyA" + name);
    }

    public void b() {
        Console.normal("自定义BeanDefinition");
    }
}
