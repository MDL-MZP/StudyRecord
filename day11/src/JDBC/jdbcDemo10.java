package JDBC;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  事务操作:
 */
public class jdbcDemo10 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            connection = JDBCUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);

            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            pstmt1 = connection.prepareStatement(sql1);
            pstmt2 = connection.prepareStatement(sql2);

            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();
            // 手动制造异常
//            int i = 3/0;
            pstmt2.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (Exception e) {   // catch 一个大异常
            // 事务回滚
            try {
                if(connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,connection);
            JDBCUtils.close(pstmt2,null);
        }
    }
}
