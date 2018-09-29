package chapter_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxin
 * @version Id: Main.java, v 0.1 2018/9/29 2:19 PM
 */
public class Main {

    public static void main(String[] args) {
//        loadXml();
        componentScan();
    }

    public static void componentScan(){
        ApplicationContext app = new AnnotationConfigApplicationContext("chapter_05");
        System.out.println(app.getBean(Book.class));
        //Book{bookName='"武林外传"', author='"周杰伦"', price=12.3, describe='${describe}'}
    }

    /**
     * 装xml的方式创建
     * 依赖get和set方法
     */
    private static void loadXml() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-value.xml");
        System.out.println(app.getBean(Book.class));
    }
}
