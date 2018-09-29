package chapter_02;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * BeanDefinition->BeanDefinitionRegistry->BeanFactory
 *
 * @author liuxin
 * @version Id: LearnBeanDefinitionRegistry.java, v 0.1 2018/6/25 下午2:35
 */
public class LearnBeanDefinitionRegistry {
    /**
     *
     * public interface BeanDefinitionRegistry extends AliasRegistry {
     * - void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)throws BeanDefinitionStoreException;
     * - void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
     * - BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
     * - boolean containsBeanDefinition(String beanName);
     * - String[] getBeanDefinitionNames();
     * - int getBeanDefinitionCount();
     * - boolean isBeanNameInUse(String beanName);
     * }
     * <p>
     * public interface AliasRegistry{
     * - void registerAlias(String name, String alias);
     * - void removeAlias(String alias);
     * - boolean isAlias(String name);
     * - String[] getAliases(String name);
     * }
     *
     * 将BeanDefinition通过BeanDefinitionRegistry注册到BeanFactory中map
     *
     * @param args
     */
    public static void main(String[] args) {
        BeanDefinitionRegistry beanDefinitionRegistry;
    }
}
