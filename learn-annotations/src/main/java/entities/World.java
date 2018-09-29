package entities;

/**
 * @author liuxin
 * @version Id: World.java, v 0.1 2018/9/28 11:26 AM
 */
public class World {

    HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public String toString() {
        return "World{" +
                "helloWorld=" + helloWorld +
                '}';
    }
}
