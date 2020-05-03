package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  c3p0 演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取datasource, 不指定name则使用默认配置
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        for (int i = 1; i <= 11 ; i++) {
            Connection connection = ds.getConnection();
        // 3. 打印
            System.out.println(i + ":" +connection);
            if(i == 5){
                connection.close();
            }
        }
//        testNamedConfig();
    }
    private static void testNamedConfig() throws SQLException {
        //1.1 获取datasource，使用指定名称配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        // 2. 获取连接对象
        for (int i = 1; i <= 10 ; i++) {
            Connection connection = ds.getConnection();
            // 3. 打印
            System.out.println(i + ":" +connection);
            if(i == 5){
                connection.close();
            }
        }
    }
}
