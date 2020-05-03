package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除一条记录
 */
public class jdbcDemo4 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from t_ua WHERE tName = '张三'";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC", "root", "5102");
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if(i > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
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
