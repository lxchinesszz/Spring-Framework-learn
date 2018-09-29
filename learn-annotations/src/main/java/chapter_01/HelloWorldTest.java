package chapter_01;

import entities.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author liuxin
 * @version Id: HelloWorldTest.java, v 0.1 2018/9/25 下午4:51
 */
public class HelloWorldTest {

    public static void main(String[] args) {
        //通过加装xml的方式创建
        loadXml();
        System.err.println("-------------------红色分隔符---------------");
        //通过注解方式
        componentScan();


    }

    /**
     * 通过注解扫描方式
     * 扫描包: chapter_01
     */
    private static void componentScan(){
        ApplicationContext aapp = new AnnotationConfigApplicationContext("chapter_01");
        HelloWorld helloWorld = aapp.getBean(HelloWorld.class);
        System.out.println(helloWorld.toString());
        System.out.println("别名:"+ Arrays.asList(aapp.getAliases("helloWorld")));
        ((AnnotationConfigApplicationContext) aapp).close();

    }
    /**
     *装xml的方式创建
     */
    private static void loadXml() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        HelloWorld helloWorld = app.getBean(HelloWorld.class);
        System.out.println(helloWorld.toString());
        System.out.println("别名:"+Arrays.asList(app.getAliases("helloWorld")));
        ((ClassPathXmlApplicationContext) app).close();
    }
}
