package com.service;

import com.dao.Newsdao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsAService {
    public void insertNew(String sub,String title,String writer,String des,String msg,String img) throws Exception {
        Newsdao nd=new Newsdao();
        nd.addNews(sub,title,writer,des,msg,img);
    }
}
