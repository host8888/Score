package com.java.test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LinkJDBC {
    private String driver;
    private String url;
    private String user;
    private String pass;
    private static LinkJDBC link;

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    private LinkJDBC(){
    }
    public static LinkJDBC getObject() throws Exception {
        if(link==null){
            link=new LinkJDBC();
            link.init();
        }
        return  link;
    }
    private void init() throws Exception {
        String path=LinkJDBC.class.getResource("").toURI().getPath()+"jdbc.xml";
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document document = db.parse(path);
        Node node= document.getElementsByTagName("jdbc").item(0);
        NodeList nolist=node.getChildNodes();
        for(int i=0;i<nolist.getLength();i++){
            Node nodes=nolist.item(i);
            if(nodes.getNodeName().equals("url")){
                url=nodes.getTextContent().trim();
            }else if(nodes.getNodeName().equals("driver")){
                driver=nodes.getTextContent().trim();
            }else if(nodes.getNodeName().equals("user")){
                user=nodes.getTextContent().trim();
            }else if(nodes.getNodeName().equals("password")){
                pass=nodes.getTextContent().trim();
            }
        }
    }
}
