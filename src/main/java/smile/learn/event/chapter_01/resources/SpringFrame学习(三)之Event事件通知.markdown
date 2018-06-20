> 在我们对事件模式有一个认知后我们来阅读源码,来寻找Spring是否也是按照我们的思路去实现呢？

![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/E92DF90EF33C49B7A6E4B3E966C496EB/12228)
![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/FD0F5A5B852645EAA3A2093B69A0C2EE/12233)

#### addApplicationListener() 跟进

我们发现了一点线索即找到了一个管理Listener的set集合个事件管理器
![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/7548CB45C1FC4C7C90AE1090EC0BEDBC/12236)


#### publishEvent跟进

![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/701B8A28805448DBB4770C10E1AD9DEC/12240)

#### multicastEvent跟进

![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/2F7B5611F4EF42B88D028DC16339CD83/12243)

![](https://note.youdao.com/yws/public/resource/329b1ea0c8facd2b13d6eae9d294fa75/xmlnote/52A3EF210A3643888949EAB7993E0F16/12245)


通过以上代码的不断跟进我们了解了Spring的事件是怎么实现的？在这里我们不追究细节。感兴趣的同学可以深入了解。
