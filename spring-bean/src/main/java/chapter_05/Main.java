package chapter_05;

import chapter_04.document.TestComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import utils.Console;

import java.util.Arrays;
import java.util.Set;

/**
 * @author liuxin
 * @version Id: Main.java, v 0.1 2018/7/5 上午10:17
 */
public class Main {
    public static void main(String[] args) {
//        annotationProcess();
//        xmlProcess();
        destroyBeansTest();

    }

    private static void destroyBeansTest() {
        Thread shutdownHook = new Thread(() -> System.out.println("执行关闭"));
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        while (true){}
    }

    private static void scannerBean() {
        /**
         * 扫描指定目录中带有指定注解的BeanDefinition
         */
        ClassPathScanningCandidateComponentProvider beanScanner = new
                ClassPathScanningCandidateComponentProvider(true);//默认值扫描ioc管理的类，false扫描自定义的
        TypeFilter includeFilter = new AssignableTypeFilter(Deprecated.class);
        beanScanner.addIncludeFilter(includeFilter);
        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents("chapter_05");
        System.out.println(beanDefinitions);
    }

    private static void xmlProcess() {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("autotest.xml");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(Console::normal);
        POJO pojo = applicationContext.getBean(POJO.class);
        pojo.execute();
        POJO pojo1 = (POJO) applicationContext.getBean("pojo");
        pojo1.execute();
        POJO pojo2 = (POJO) applicationContext.getBean("pojo2");
        pojo2.execute();

        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("chapter_05.DependencyA");
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        //注册bean描述类
        genericApplicationContext.registerBeanDefinition("demo", beanDefinition);
        //刷新容器
        genericApplicationContext.refresh();
        DependencyA bean = genericApplicationContext.getBean(DependencyA.class);
        bean.b();
    }

    private static void annotationProcess() {
        AnnotationConfigApplicationContext annotationApplicationContext =
                new AnnotationConfigApplicationContext();
        Arrays.stream(annotationApplicationContext.getBeanDefinitionNames()).forEach(Console::normal);
        annotationApplicationContext.scan("chapter_05");
        annotationApplicationContext.refresh();
        String[] beanDefinitionNames = annotationApplicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            Console.log(beanName);
        }
        DependencyA bean = annotationApplicationContext.getBean(DependencyA.class);
        POJO bean1 = annotationApplicationContext.getBean(POJO.class);
    }


}
