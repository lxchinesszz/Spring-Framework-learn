package entity;

import org.springframework.beans.factory.BeanNameAware;
import utils.Console;

/**
 * @author liuxin
 * @version Id: CheckAware.java, v 0.1 2018/6/25 上午10:15
 */
public class CheckAware implements BeanNameAware {
    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName=name;
    }

    public String printBeanName(){
        Console.normal(this.beanName);
        return this.beanName;
    }
}
