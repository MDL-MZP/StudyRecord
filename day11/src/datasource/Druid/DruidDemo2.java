package datasource.Druid;

import datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的Druid工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        /**
         *  完成添加的操作，给accout添加一条记录
         */
        try {
            connection = JDBCUtils.getConnection();
            // 定义sql
            String sql = "insert into account values(null,?,?)";
            // 获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,connection);
        }
    }
}
