package chapter_04;

import entities.HelloWorld;
import entities.World;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author liuxin
 * @version Id: InjectTest.java, v 0.1 2018/9/28 11:25 AM
 */
public class InjectTest {

    public static void main(String[] args) {
//        loadXml();
        componentScan();
    }

    /**
     * 装xml的方式创建
     */
    private static void loadXml() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-inject.xml");
        World world = app.getBean(World.class);
        System.out.println(world);
        //World{helloWorld=HelloWorld{describe='hello world'}}
    }

    /**
     * 通过注解扫描方式
     * 扫描包: chapter_01
     */
    private static void componentScan(){
        ApplicationContext aapp = new AnnotationConfigApplicationContext("chapter_04");
        A a = aapp.getBean(A.class);
        System.out.println(a.toString());

    }
}
