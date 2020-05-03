package JDBCTemplate;

import datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  JDBCTemplate 入门
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        // 1. 导入jar包
        // 2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
            //  修改 id 为 3 的，按顺序写 参数 ？
        int count = template.update(sql, 3);
        // 已经归还连接，释放资源 👍
        System.out.println(count);
    }
}
