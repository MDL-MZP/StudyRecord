package JDBC;

import java.sql.*;

/**
 *  select 所有数据
 */
public class jdbcDemo7 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from t_ua";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC", "root", "5102");
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            // 处理结果
                // 1. 让光标不断向下移动一行
            while(rs.next()) {
                // 2. 获取数据
                int id = rs.getInt(1);
                String name = rs.getString("tName");
                String gender = rs.getString(3);
                System.out.println(id + " --- " + name + " --- " + gender);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 避免空指针异常，才去释放
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

    }
}
