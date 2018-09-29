package chapter_05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @version Id: POJO.java, v 0.1 2018/7/5 上午10:16
 */
@Component
@Deprecated
public class POJO {

    private String name;

    private DependencyA dependency;
    public POJO(){}
    @Autowired
    public POJO(DependencyA dependency){
        this.dependency=dependency;
    }

    public void execute(){
        dependency.a(this.name);
    }

    public void setDependency(DependencyA dependency) {
        this.dependency = dependency;
    }

    public void setName(String name) {
        this.name = name;
    }
}
