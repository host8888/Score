package com.java.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.MacSpi;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBimpl {
    private  SqlSession sqs=null;
    @Before
    public void init() throws IOException {
            SqlSessionFactoryBuilder sqb = new SqlSessionFactoryBuilder();
            InputStream input = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqf = sqb.build(input);
            sqs = sqf.openSession();
    }
    @Test
    public void selectAll() {
            List<Map<String, Object>> list = sqs.selectList("com.java.impl.DBimpl.selectAll");
            list.forEach(temp -> System.out.println(temp));
    }
    @Test
    public void selectOne(){
       Map<String,Object> byid=sqs.selectOne("com.java.impl.DBimpl.selectOne",2L);
        byid.forEach((k,v)-> System.out.println(k+" , "+v));
    }
    @Test
    public void selectMore(){
//        Map<String,Object> mor=new HashMap<>();
//        mor.put("name","张%");
//        mor.put("age","20");
        Mydb byid=new Mydb();
        byid.setAge("20");
        byid.setName("张%");
//        List<Map<String, Object>> byids = sqs.selectList("com.java.impl.DBimpl.selectAll",byid);
        List<Mydb> byidy = sqs.selectList("com.java.impl.DBimpl.selectAll",byid);
//        byidy.forEach(tem-> System.out.println(tem));
        System.out.println(byidy);
    }
    @Test
    public void insertAll(){
        Map<String,Object> map=new HashMap<>();
        map.put("sid",03);
        map.put("name","王五");
        map.put("score",80);
        sqs.insert("com.java.impl.DBimpl.insertAll",map);

    }
    @Test
    public void deleteOne(){
//        sqs.delete("com.java.impl.DBimpl.deleteOne");
        sqs.delete("com.java.impl.DBimpl.deleteOne",3L);
    }
    @Test
    public void updateById(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",4);
        map.put("sid",1);
        map.put("name","马六");
        map.put("score",99);
       int a= sqs.update("com.java.impl.DBimpl.updateById",map);
        System.out.println(a);
    }
    @Test
    public void selectM(){
    Map<String,Object> map=new HashMap<>();
    map.put("name","郑");
    map.put("age",20);
    List<Map<String,Object>> result=sqs.selectList("com.java.impl.DBimpl.selectM",map);
        System.out.println(result);
    }
    @Test
    public void selectChose(){
        Map<String,Object> map=new HashMap<>();
        map.put("age",20);
        List<Map<String,Object>> list=sqs.selectList("com.java.impl.DBimpl.selectChose",map);
        list.forEach(one-> System.out.println(one));
    }
    @Test
    public void updateAuto(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("name","马六");
        int result=sqs.update("com.java.impl.DBimpl.updateAuto",map);
    }
    @After
    public void destory(){  //提交事务
        sqs.commit();
    }
}
