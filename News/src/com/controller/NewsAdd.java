package com.controller;


import com.service.NewsAService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/newsAdd")
public class NewsAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=UTF-8");
       boolean isMult= ServletFileUpload.isMultipartContent(req);
        String sub = null;
        String title= null;
        String writer= null;
        String des= null;
        String msg= null;
        String img=null;
        if(isMult){
            FileItemFactory factory= new DiskFileItemFactory();
            ServletFileUpload up=new ServletFileUpload( factory);
            try {
                List<FileItem> items=up.parseRequest(req);
                Iterator<FileItem> it=items.iterator();
                while(it.hasNext()){
                    FileItem f=it.next();
                    String itname=f.getFieldName();
                    if(f.isFormField()){
                        if(itname.equals("subject")){
                            sub=f.getString("UTF-8");
                        }else if(itname.equals("title")){
                            title=f.getString("UTF-8");
                        }else if(itname.equals("writer")){
                            writer=f.getString("UTF-8");
                        }else if(itname.equals("des")){
                            des=f.getString("UTF-8");
                        }else if(itname.equals("msg")){
                            msg=f.getString("UTF-8");
                        }
                    }else {
                        String filename=f.getName();
                        String files = this.getClass().getResource("/").getPath();
                        String path=req.getSession().getServletContext().getRealPath("images");
                        img="images/"+filename;
                        File file=new File(path,filename);
                        f.write(file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        NewsAService nw=new NewsAService();
        try {
            System.out.println(img);
            nw.insertNew(sub,title,writer,des,msg,img);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
