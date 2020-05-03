package JDBC;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 		1. 通过键盘录入用户名和密码
 * 		2. 判断用户是否登录成功
 */
public class jdbcDemo9 {
    public static void main(String[] args) {
        // 1. 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        // 2. 调用方法
        long l1 = System.currentTimeMillis();
//        boolean flag = new jdbcDemo9().login(username, password);
        boolean flag = new jdbcDemo9().login2(username, password);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1+"ms");
        // 3. 判断结果
        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }

    /**
     *  登录方法, 存在安全问题, 密码输入  a' or 'a' = 'a  显示登录成功
     *  sql注入问题
     */
    public boolean login(String username,String password) {
        if(username == null || password == null){
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        // 1. 获取连接
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where username = '"+ username +"' and password = '"+ password +"'";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection,rs);
        }
        return false;
    }


    /**
     *  登录方法,使用PreparedStatement,避免sql注入
     */
    public boolean login2(String username,String password) {
        if(username == null || password == null){
            return false;
        }
        Connection connection = null;
        PreparedStatement  pstmt = null;
        ResultSet rs = null;
        // 1. 获取连接
        try {
            connection = JDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "select * from user where username = ? and password = ? ";
            // 3. 获取执行sql对象
            pstmt = connection.prepareStatement(sql);
                // 给 ? 赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            // 4. 执行
            rs = pstmt.executeQuery();
            // 5. 判断
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // PreparedStatement是Statement子类
            JDBCUtils.close(pstmt,connection,rs);
        }
        return false;
    }
}
