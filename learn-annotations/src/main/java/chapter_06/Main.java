package chapter_06;

import chapter_05.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author liuxin
 * @version Id: Main.java, v 0.1 2018/9/29 3:52 PM
 */
@ComponentScan(value={"chapter_05"},excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {TypeExcludeFilter.class}),
})
public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(Main.class);
        System.out.println(app.getBean(Book.class));
    }
}
