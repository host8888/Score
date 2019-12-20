package com.utils;

import java.sql.*;

public class DButil {
	public static String user;
	private static String pass;
	private static String dir;
	private static String url;
	static Connection con=null;
	private static void getObject() throws Exception {
		DBlink db=DBlink.instance();
		user=db.getUser();
		pass=db.getPwd();
		dir=db.getDriver();
		url=db.getURL();
	}
	public static Connection getConnection() throws Exception {
		getObject();
		try {
			Class.forName(dir);
			con= DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}	
		return con;
	}
	public static Connection closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
		return con;	
	}
	public static int SQLment(String sql,Object...prame) throws SQLException {//可变长任意类型参数
		int  rest=0;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			pst=con.prepareStatement(sql);//预处理SQL
			if(prame!=null && prame.length>0) {//判读参数是否为空
				for(int i=0;i<prame.length;i++) {//逐个获取参数加入SQL语句执行
					pst.setObject(i+1, prame[i]);
				}
				rest=pst.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection();
	return rest;
	}
}
