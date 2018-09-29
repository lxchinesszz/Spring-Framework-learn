package chapter_04.document;

import org.springframework.stereotype.Component;
import utils.Console;

/**
 * @author liuxin
 * @version Id: TestComponent.java, v 0.1 2018/7/11 下午2:29
 */
@Component
public class TestComponent {
    String name;
    int age;
    public void say(String message){
        Console.normal(message);
    }
}
