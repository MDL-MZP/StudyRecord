package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 添加一条记录
 */
public class jdbcDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into t_ua(tName,tGender) values('张三','男')";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC", "root", "5102");
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if(i > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
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
        }

    }
}
