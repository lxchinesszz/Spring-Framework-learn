package chapter_04;

/**
 * @author liuxin
 * @version Id: B.java, v 0.1 2018/9/28 3:51 PM
 */
public class B {
    String name;

    public B(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}
