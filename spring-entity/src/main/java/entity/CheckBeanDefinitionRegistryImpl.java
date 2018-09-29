package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import utils.Console;

/**
 * @author liuxin
 * @version Id: CheckBeanDefinitionRegistryImpl.java, v 0.1 2018/6/26 上午8:58
 */
public class CheckBeanDefinitionRegistryImpl implements BeanDefinitionRegistryPostProcessor {

    /**
     * 在注册BeanDefinition类的时候提供给以开发者修改的机会BeanDefinition的第一次机会
     * 根据BeanName = "checkCustomerClosed" 的类自定义销毁方法
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition checkBeanFactoryPostProcessor = registry.getBeanDefinition("checkCustomerClosed");
        //给指定的BeanDefinition的类设置销毁方法。
        ((GenericBeanDefinition) checkBeanFactoryPostProcessor).setDestroyMethodName("customerClosed");
        ((GenericBeanDefinition) checkBeanFactoryPostProcessor).getPropertyValues().addPropertyValue("test","第一次修改的描述信息");
        Console.customerNormal("BeanDefinitionRegistryPostProcessor中修改的BeanDefinition的扩展点","BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
    }


    /**
     * 第二次机会
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition checkBeanFactoryPostProcessor = beanFactory.getBeanDefinition("checkCustomerClosed");
        checkBeanFactoryPostProcessor.getPropertyValues().addPropertyValue("test","第二次修改的描述信息");
        Console.customerNormal("BeanFactoryPostProcessor中修改BeanDefinition的扩展点","BeanFactoryPostProcessor.postProcessBeanFactory()");
    }


}
