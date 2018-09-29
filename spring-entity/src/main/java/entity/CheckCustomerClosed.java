package entity;
import utils.Console;

/**
 * @author liuxin
 * @version Id: CheckBeanFactoryPostProcessor.java, v 0.1 2018/6/26 上午8:51
 */
public class CheckCustomerClosed {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void customerClosed(){
        Console.normal("自定义销毁方法");
    }
}
