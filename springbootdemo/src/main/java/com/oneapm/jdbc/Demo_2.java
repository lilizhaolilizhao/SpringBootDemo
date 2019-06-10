package com.oneapm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo_2 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            testPrepareStatement();
            Thread.sleep(5000L);
        }
    }

    private static void testPrepareStatement() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection ct = null;

        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.得到连接
            //调用DriverManager对象的getConnection()方法，获得一个Connection对象
            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdemo?useSSL=true", "root", "root");

            //3.创建PreparedStatement
            ps = ct.prepareStatement("select * from user where id=? and nickname=?");

            ps.setInt(1, 1);
            ps.setString(2, "Steve");

            System.out.println(ps.getParameterMetaData());
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}