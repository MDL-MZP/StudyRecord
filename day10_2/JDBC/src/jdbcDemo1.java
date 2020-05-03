import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        // 2. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3. 获取数据库连接对象
                    //  连接的url配置：jdbc:mysql:// ip: mysql端口号/ 数据库 ？serverTimezone=UTC&useSSL=true
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:5102/myemployees?serverTimezone=UTC&useSSL=true", "root", "5102");
        // 4. 定义sql语句
        String sql = "update t_ua set tGender='女' where t_id = 2";
        // 5. 获取执行sql的执行对象 Statement
        Statement statement = root.createStatement();
        // 6. 执行sql
        int i = statement.executeUpdate(sql);
        // 7. 处理结果
        System.out.println(i);
        // 8. 释放资源
        statement.close();
        root.close();
    }
}
