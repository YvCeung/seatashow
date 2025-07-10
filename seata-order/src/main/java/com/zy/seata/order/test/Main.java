package com.zy.seata.order.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description
 * @Author zy
 * @Date 2025/7/10 23:04
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("dm.jdbc.driver.DmDriver");
        String url = "jdbc:dm://127.0.0.1:5236/SEATA3?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8";
        String user = "SEATA3";
        String pwd = "your_password"; // 换成你的密码
        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            System.out.println("连接成功！");
        }
    }

}
