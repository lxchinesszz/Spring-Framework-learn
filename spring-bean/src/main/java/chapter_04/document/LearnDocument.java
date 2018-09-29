package chapter_04.document;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author liuxin
 * @version Id: LearnDocument.java, v 0.1 2018/7/10 下午3:54
 */
public class LearnDocument {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        InputStream resourceAsStream = LearnDocument.class.getClassLoader().getResourceAsStream("test.xml");
        Document document = documentBuilder.parse(resourceAsStream);
        Element documentElement = document.getDocumentElement();
        System.out.println("root节点名称:"+documentElement.getTagName());
        System.out.println("根节点属性name值:"+documentElement.getAttribute("name"));
        if (documentElement.hasChildNodes()){
            NodeList childNodes = documentElement.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i <length ; i++) {
                Node item = childNodes.item(i);
                System.out.println(item.getNodeName()+":"+item.getTextContent());
            }
        }
    }
}
