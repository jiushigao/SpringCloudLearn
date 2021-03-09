package com.springcloud.springcloudzuul;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@SpringBootTest
public class SpringcloudZuulApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("src/main/resources/demo.xml");
            NodeList sList = d.getElementsByTagName("student");
            Node node = sList.item(0);

            System.out.println(node.getAttributes().getNamedItem("rollno").getNodeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
