package subclasstest;

/**
 * @author liuxin
 * @version Id: Main.java, v 0.1 2018/7/18 上午10:58
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Class<Father> fatherClass = Father.class;
        Class<Son> sonClass = Son.class;

        Class<Person> personClass = Person.class;
        Class<Boy> boyClass = Boy.class;
        System.out.println(fatherClass.isAssignableFrom(sonClass));
        System.out.println(sonClass.isAssignableFrom(fatherClass));
        System.out.println(personClass.isInterface());
        System.out.println(personClass.isInstance(new Son()));
        System.out.println(boyClass.isInstance(new Son()));
    }
}
