package com.java.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Iterator;

public class DOM4J {
    private void parserXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext(); ) {
                Element employee = (Element) i.next();
                for (Iterator j = employee.elementIterator(); j.hasNext(); ) {
                    Element node = (Element) j.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dom4j解析文件完成！");
    }
    public void createXml(String fileName) {
        Document document = DocumentHelper.createDocument();
        Element persons = document.addElement("employees");
        Element person = persons.addElement("employee");
        Element name = person.addElement("name");
        name.setText("张三");
        Element sex = person.addElement("sex");
        sex.setText("男");
        Element age = person.addElement("age");
        age.setText("24");
        try {
            Writer fileWriter = new FileWriter(fileName);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws URISyntaxException {
        DOM4J DOM4JRead=new DOM4J();
        String file= DOM.class.getResource("").toURI().getPath()+"Student.xml";
        DOM4JRead.parserXml(file);
//        DOM4JRead.parserXml("School.xml");
//        DOM4JRead.createXml("Person.xml");
    }
}
