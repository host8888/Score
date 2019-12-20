package com.java.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetLink {
    private String url;
    private String user;
    private String driver;
    private String pass;
    private Connection con=null;
    private void getlink(){
        try {
            LinkJDBC lk= LinkJDBC.getObject();
            url=lk.getUrl();
            user=lk.getUser();
            driver=lk.getDriver();
            pass=lk.getPass();
            System.out.println("链接："+url+"  驱动："+driver+"  用户名："+user+"  密码："+pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,pass);
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  con;
    }

    private void Sql(){
        PreparedStatement pst=null;
        GetLink glk=new GetLink();
        glk.getlink();
        String sql="select * from infor limit 9990,10";

        try{
            con=glk.getConnection();
            pst=con.prepareStatement(sql);
            ResultSet re=pst.executeQuery();
            while(re.next()){
                String name=re.getString("name");
                int id=re.getInt(1);
                String age=re.getString("age");
                String sex=re.getString("sex");
                String phone=re.getString("phome");
                String address=re.getString("address");
                System.out.println("id:"+id+"  姓名："+name+"  年龄："+age+"  性别："+sex+"  电话："+phone+"  地址："+address);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GetLink glk=new GetLink();
//        glk.getlink();
//        glk.getConnection();
        glk.Sql();
    }
}
