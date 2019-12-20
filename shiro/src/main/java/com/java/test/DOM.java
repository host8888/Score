package com.java.test;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.net.URISyntaxException;

public class DOM {

    private void create(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            // 第一步：创建DOM树
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            document.setXmlStandalone(true);
            // 第二步：完善树结构
            // 创建节点
            Element bookstore = document.createElement("bookstore");
            Element book1 = document.createElement("book");
            Element book2 = document.createElement("book");
            Element name1 = document.createElement("name");
            Element price1 = document.createElement("price");
            Element when1 = document.createElement("when");
            Element name2 = document.createElement("name");
            Element price2 = document.createElement("price");
            Element when2 = document.createElement("when");
                  // 设置节点的属性、内容
             book1.setAttribute("from", "China");
             book2.setAttribute("from", "America");
             name1.setTextContent("三国演义");
             price1.setTextContent("￥89");
             when1.setTextContent("2017版");
             name2.setTextContent("JavaScript高级程序设计");
             price2.setTextContent("$18");
             when2.setTextContent("2016");
                  // 将子节点添加到父节点
             book1.appendChild(name1);
             book1.appendChild(price1);
             book1.appendChild(when1);
             book2.appendChild(name2);
             book2.appendChild(price2);
             book2.appendChild(when2);
             bookstore.appendChild(book1);
             bookstore.appendChild(book2);
             document.appendChild(bookstore);
             // 第三步：将树结构导入book.xml文件中
             TransformerFactory tff = TransformerFactory.newInstance();
             Transformer tf = tff.newTransformer();
             tf.setOutputProperty(OutputKeys.INDENT, "yes");// 节点换行
             tf.transform(new DOMSource(document), new StreamResult("book.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void parsersXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList employees = document.getChildNodes();
            for (int i = 0; i < employees.getLength(); i++) {
                Node employee = employees.item(i);
                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);
                    NodeList employeeMeta = node.getChildNodes();
                    for (int k = 0; k < employeeMeta.getLength(); k++) {
                        System.out.println(employeeMeta.item(k).getNodeName() + ":" + employeeMeta.item(k).getTextContent());
                    }
                }
            }
            System.out.println("解析完毕");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws URISyntaxException {
        DOM domread=new DOM();
        String file= DOM.class.getResource("").toURI().getPath()+"Student.xml";
        String files="src/main/java/com/java/test/Student.xml";
        domread.parsersXml(files);
//        domread.create();
    }
}
