package chapter_06.proxy;

import java.lang.reflect.Proxy;

/**
 * @author liuxin
 * @version Id: Liudehua.java, v 0.1 2018/7/20 下午4:46
 */
interface Singer {
    void sing(String song);
}

class Liudehua implements Singer {
    @Override
    public void sing(String song) {
        System.out.println("刘德华唱了一首:" + song);
    }
}
class LdhProxy {
    public static void yanchagnhui() {
        System.out.println("开场报幕");
        new Liudehua().sing("忘情水");
        System.out.println("结束再见");
    }

    public static void main(String[] args) {
        LdhProxy.yanchagnhui();

    }
}
