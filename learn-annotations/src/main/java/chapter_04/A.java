package chapter_04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liuxin
 * @version Id: A.java, v 0.1 2018/9/28 3:51 PM
 */
@Component
public class A {


    @Resource(name = "b1")
    B bb1;

//    @Qualifier(value = "b2")
    @Autowired
    B bb2;

    @Override
    public String toString() {
        return "A{" +
                "b1=" + bb1 +
                ", b2=" + bb2 +
                '}';
    }
}
