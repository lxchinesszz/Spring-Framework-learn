package chapter_02;

import entity.Person;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 负责将BeanDefinition转换为JavaBean对象
 * <p>
 * BeanDefinition->BeanDefinitionRegistry->BeanFactory
 *
 * @author liuxin
 * @version Id: Main.java, v 0.1 2018/6/7 下午7:45 liuxin Exp $$
 */
public class LearnBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory;
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("person.xml");
        Person bean = xml.getBean(Person.class);
        bean.say();
        xml.close();

    }
}
