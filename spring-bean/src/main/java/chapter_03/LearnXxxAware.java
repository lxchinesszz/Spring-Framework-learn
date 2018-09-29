package chapter_03;

import entity.CheckAware;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 当实现了xxxAware接口
 * 会自动注入xxx到继承类中
 *
 * @author liuxin
 * @version Id: LearnAware.java, v 0.1 2018/6/25 上午10:12
 */
public class LearnXxxAware {
    public static void main(String[] args) {
        Aware();
    }

    private static void Aware() {
        /**
         * 是一个空实现
         * 主要起到一个标志作用表明了一类实现
         */
        Aware aware;

        BeanNameAware beanNameAware;

        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("checkaware.xml");
        /**
         * 当实现了xxxAware接口
         * 会自动注入xxx到继承类中
         * 这里继承了BeanNameAware所以就将BeanName通过setBeanName 继承进来
         */
        CheckAware checkAware = xml.getBean(CheckAware.class);
        checkAware.printBeanName();
        xml.close();
    }
}
