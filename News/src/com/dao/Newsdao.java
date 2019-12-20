package com.dao;

import com.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Newsdao {
    PreparedStatement ps=null;
    Connection con=null;
    public void addNews(String sub,String title,String writer,String des,String msg,String img) throws Exception {
//        String sql="insert into newinfo(writer,subject,title,des,imgPath) values(?,?,?,?,?,?)";
//        String sql2="insert into news(title,msg) values(?,?)";
//        DButil.SQLment(sql,writer,sub,title,des,img);
//        DButil.SQLment(sql2,title,msg);
        con=DButil.getConnection();
        String sql="insert into newinfo(writer,subject,title,des,imgPath) values('"+writer+"','"+sub+"','"+title+"','"+des+"','"+img+"')";
        String sql2="insert into news(title,msg) values('"+title+"','"+msg+"')";
        System.out.println(sql);
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        ps=con.prepareStatement(sql2);
        ps.executeUpdate();
    }
}

