package com.java.impl;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lamb {
    @Test
    public void read() throws IOException {
        FileInputStream input = null;
        try {
            input=new FileInputStream("F:\\Java\\Code\\mytest\\src\\com\\test\\Hash.java");
            byte[] byt=new byte[2048];
            int len=input.read(byt);
            String code=new String(byt);
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            input.close();
        }

    }
}
