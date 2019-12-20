package com.java.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Snfor {
    private SqlSession sqs=null;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqb = new SqlSessionFactoryBuilder();
        InputStream input = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqf = sqb.build(input);
        sqs = sqf.openSession();
    }
    @Test
    public void selectPage(){
        int num=1;
        int size=10;
        PageHelper.startPage(num,size);
        List<Map<String,Object>> list=sqs.selectList("com.java.impl.Snfor.selectPage");
//        list.forEach(print-> System.out.println(print));
        PageInfo<Map<String,Object>> pageinfo=new PageInfo<Map<String,Object>>(list);
        List<Map<String,Object>> result=pageinfo.getList();
        result.forEach(tem-> System.out.println(tem));
    }
    @After
    public void destory(){  //提交事务
        sqs.commit();
    }
}
