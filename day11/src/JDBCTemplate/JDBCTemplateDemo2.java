package JDBCTemplate;

import datasource.utils.JDBCUtils;
import domain.account;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *  Junit单元测试，让方法单独执行
 *  写个 @Test ，点击小灯泡，加载Junit4
 */
public class JDBCTemplateDemo2 {
    /**
        1. 获取JDBCTemplate对象  */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test1(){
        //2. 定义sql
        String sql = "update account set balance = 10000 where id = 1";
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){
        //2. 定义sql
        String sql = "insert into account values(?,?,?)";
        int count = template.update(sql,4,"马志鹏",100000);
        System.out.println(count);
    }

    @Test
    public void test3(){
        //2. 定义sql
        String sql = "delete from account where id = ?";
        int count = template.update(sql,4);
        System.out.println(count);
    }

    @Test
    public void test4(){
        String sql = "select * from account where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
        //{  id=1, name=zhangsan, balance=10000.0  }
    }

    @Test
    public void test5(){
        String sql = "select * from account";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
       /*
            {id=1, name=zhangsan, balance=10000.0}
            {id=2, name=lisi, balance=1000.0}
            {id=3, name=王五, balance=5000.0}
        */
    }

    @Test
    public void test6(){
        String sql = "select * from account";
        List<account> list = template.query(sql, new RowMapper<account>() {
            @Override
            public account mapRow(ResultSet rs, int i) throws SQLException {
                account ac = new account();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                ac.setId(id);
                ac.setBalance(balance);
                ac.setName(name);
                return ac;
            }
        });
        for (account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void test6_2(){
        String sql = "select * from account";
        List<account> list = template.query(sql, new BeanPropertyRowMapper<account>(account.class));
        for (account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void test7(){
        String sql = "select count(id) from account";
        // Long.class 似乎是将返回结果以Long类型存在
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total); }

}
