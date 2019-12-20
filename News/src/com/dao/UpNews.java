package com.dao;

import com.utils.DButil;

public class UpNews {
    public void upNw(String id,String sub,String title,String writer,String des,String msg,String img) throws Exception {
        String sql="update newinfo set writer=?,subject=?,title=?,des=?,imgpath=? where id=?";
        String sql2="update news set title=?,mag=? where id=?";
        DButil.SQLment(sql,writer,sub,title,des,img,id);
        DButil.SQLment(sql2,title,msg,id);
    }
}
