package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import utils.Console;

import java.lang.reflect.Field;

/**
 * 该方法会在Bean初始化前和初始化后执行
 *
 * @author liuxin
 * @version Id: CheckBeanPostProcessor.java, v 0.1 2018/6/26 上午9:09
 */
public class CheckBeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Console.customerNormal("postProcessBeforeInitialization", "执行");
        //Person的name属性是写死的，所以初始化前就有
        if (bean instanceof Person) {
            ((Person) bean).say();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Console.customerNormal("postProcessAfterInitialization", "执行");
        //在类初始化后我们反射修改他
        if (bean instanceof Person) {
            try {
                Field name = ((Person) bean).getClass().getDeclaredField("name");
                name.setAccessible(true);
                name.set(bean,"CUSTOMER");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
