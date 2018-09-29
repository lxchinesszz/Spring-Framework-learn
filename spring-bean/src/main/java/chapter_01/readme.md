
### XML文件是如何转换成Java Bean对象呢？

*我们知道XML只是Bean数据的一个载体,里面存放着Class的完整限定名,Class 是否单例及内部类的依赖对象
但是总归来说XML和Class都可以作为数据的载体,于是乎我们定义一个BeanDefinition类,来讲XML的数据放到Java对象中
然后通过对Java对象的解析,从而来生成JavaBean对象*

#### ①: 通过dom4j,将xml准换为BeanDefinition

这之间经过了什么呢？[@spring-bean/chapter_01/io,@spring-bean/chapter_01/xml]

- 拿到xml配置文件地址
- 通过XmlBeanDefinitionReader将xml地址,转换为Dom对象
- 对DOM对象进行解析,拿到XML定义的各种属性，生成BeanDefinition对象

#### ②: 对DeanDefinition进行解析最终生成JavaBean,并保存到一个容器(说白了容器就是一个map对象)

这之间经过了什么呢？[@spring-bean/chapter_01/factory]

- AutowireBeanFactory.doCreate(BeanDefinition)生成Bean对象并保存到Map中
