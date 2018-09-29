package chapter_02;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author liuxin
 * @version Id: chapter_02.java, v 0.1 2018/9/26 下午2:12
 */
public class ScopeTest {

    public static void main(String[] args) {
        loadXml();
    }

    /**
     * 通过注解扫描方式
     * 扫描包: chapter_01
     */
    private static void componentScan() {
        ApplicationContext aapp = new AnnotationConfigApplicationContext("chapter_01");
        aapp.getBean("prototype_hello");
        aapp.getBean("prototype_hello");


    }

    /**
     * 装xml的方式创建
     */
    private static void loadXml() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-scope.xml");
        app.getBean("singleton_hello");
        /**
         * 因为是单例的,所以无论加载几次都执行一次init方法
         */
        System.out.println(app.getBean("singleton_hello"));
        System.out.println(app.getBean("singleton_hello"));

        /**
         * 每次生成都执行一次init方法
         */
        System.out.println(app.getBean("prototype_hello"));
        System.out.println(app.getBean("prototype_hello"));

    }
}
