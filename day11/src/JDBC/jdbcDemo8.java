package JDBC;

import domain.t_ua;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  定义一个方法，查询t_ua表的数据将其封装为对象，然后装载集合，返回。
 */
public class jdbcDemo8 {
    public static void main(String[] args) {
        List<t_ua> list = new jdbcDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * 查询所有t_ua对象
     * @return
     */
        public List<t_ua> findAll(){
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            List<t_ua> list = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC", "root", "5102");
                String sql = "select * from t_ua";
                statement = connection.createStatement();
                rs = statement.executeQuery(sql);
                // 引用，封装、装载集合
                t_ua t = null;
                list = new ArrayList<t_ua>();
                while(rs.next()){
                    int id = rs.getInt("t_id");
                    String name = rs.getString("tName");
                    String gender = rs.getString("tGender");
                    // 创建对象并赋值
                    t = new t_ua();
                    t.setId(id);
                    t.setName(name);
                    t.setGender(gender);
                    // 装载集合
                    list.add(t);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(statement != null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(connection != null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(rs != null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return list;
        }

    /**
     * 演示 JDBCUtils 工具类, 连接不同的数据库,只需要在配置文件中修改
     * @return
     */
    public List<t_ua> findAll2(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<t_ua> list = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC", "root", "5102");
            connection = JDBCUtils.getConnection();
            String sql = "select * from t_ua";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            // 引用，封装、装载集合
            t_ua t = null;
            list = new ArrayList<t_ua>();
            while(rs.next()){
                int id = rs.getInt("t_id");
                String name = rs.getString("tName");
                String gender = rs.getString("tGender");
                // 创建对象并赋值
                t = new t_ua();
                t.setId(id);
                t.setName(name);
                t.setGender(gender);
                // 装载集合
                list.add(t);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if(statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null){
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(rs != null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            JDBCUtils.close(statement,connection,rs);
        }
        return list;
    }
}
