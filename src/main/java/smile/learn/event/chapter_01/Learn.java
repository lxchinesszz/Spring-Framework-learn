package smile.learn.event.chapter_01;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smile.utils.Console;

/**
 * 在学习Spring Event的前提是你需要了解什么是事件模式
 * 从设计模式上讲:
 * 1. 事件模式和订阅者模式是类似的即
 * eg: 当你订阅了一个公众号,该公众号每天会给你推送最新的文章,该文章就相当于一个推送事件,会给每个订阅的人都发送
 * 那么代码上如何去实现呢?
 * List<订阅的人>.foreach(循环遍历订阅的人,然后给每个订阅的人发送消息)
 *
 * public class ApplicationContext(){
 * List<SmileListener> listeners=new ArrayList<SmileListener>();
 * publishEvent(SmileListener);
 * void publishEvent(Event event){
 * listeners.stream().forEach(listener->listener.onApplicationEvent(event));
 * }
 * }
 * 具体看resources/Event代码实现.md
 *
 * @author liuxin
 * @version Id: Learn.java, v 0.1 2018/6/20 上午11:18 liuxin
 * @date 2018/6/20 下午12:33
 * @return
 * @link https://www.toutiao.com/item/6517166246314639880/
 */
public class Learn {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("person.xml");

        /******************************①: 定义监听器 *********************************/


        /**
         * 定义监听器
         */
        applicationContext.addApplicationListener(new SmileListener());


        /******************************②: 发送事件 *********************************/

        /**
         * result:hello world
         * 分析:
         * 因为我们定义的事件类中有printMsg方法,且在监听器中判断如果是SmileEvent就打印该方法
         */
        applicationContext.publishEvent(new SmileEvent("hello world"));

        /**
         * result:
         *  原始资源:other event
         *  创建时间:1529467536735
         * 分析:
         *  该事件类中并没有任何方法,只有一个构造为什么也会打内容打印出来呢？
         *  有经验的developer一定会想到一定是该类继承的父类把内容打印出来了。
         *  究竟是不是这样呢？ 跟着我开始分析源码吧>> /resources/SpringFrame学习(三)之Event事件通知.pdf
         */
        applicationContext.publishEvent(new OtherEvent("other event"));
    }

    /**
     * 定义监听器
     */
    private static class SmileListener implements ApplicationListener {
        public void onApplicationEvent(ApplicationEvent event) {
            if (event instanceof SmileEvent) {
                ((SmileEvent) event).printMsg();
            } else {
                Console.log("原始资源:" + event.getSource());
                Console.log("创建时间:" + event.getTimestamp());
            }
        }
    }

    /**
     * 定义事件
     */
    private static class SmileEvent extends ApplicationEvent {
        private String message;

        SmileEvent(String message) {
            super(message);
            this.message = message;
        }

        void printMsg() {
            Console.log(message);
        }
    }

    /**
     * 其他定义事件
     */
    private static class OtherEvent extends ApplicationEvent {
        OtherEvent(String message) {
            super(message);
        }
    }


}
