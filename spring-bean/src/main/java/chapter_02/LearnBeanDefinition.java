package chapter_02;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.lang.Nullable;


/**
 * Bean描述类
 * BeanDefinition->BeanDefinitionRegistry->BeanFactory
 * @author liuxin
 * @version Id: LearnBeanDefinition.java, v 0.1 2018/6/25 上午9:16
 */
public class LearnBeanDefinition {
    public static void main(String[] args) {
        /**
         * BeanDefinition
         * 无论是使用注解@Component
         * 还是使用XMl的方式声明Bean
         * 其最后还是会被解析成BeanDefinition,然后通过BeanDefinitionRegistry注册到
         * BeanFactory的Map中保存
         *
         * -----------------------------------------------------------------------------------
         * ### AbstractBeanDefinition: ###
         * >>>>>>>>>>>>>>>>>>>>>>>>>>
         * beanClass保存bean的class属性，
         * scope保存bean是否单例，
         * abstractFlag保存该bean是否抽象，
         * lazyInit保存是否延迟初始化，
         * autowireMode保存是否自动装配，
         * dependencyCheck保存是否坚持依赖，
         * dependsOn保存该bean依赖于哪些bean(这些bean必须提取初始化)，
         * constructorArgumentValues保存通过构造函数注入的依赖，
         * propertyValues保存通过setter方法注入的依赖，
         * factoryBeanName和factoryMethodName用于factoryBean
         * -----------------------------------------------------------------------------------
         */
        BeanDefinition beanDefinition = new AbstractBeanDefinition() {
            @Override
            public AbstractBeanDefinition cloneBeanDefinition() {
                return null;
            }

            @Override
            public void setParentName(@Nullable String parentName) {

            }

            @Override
            public String getParentName() {
                return null;
            }
        };

    }
}
