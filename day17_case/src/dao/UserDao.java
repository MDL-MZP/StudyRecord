package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User> findAll();

    public void insert(Map<String, String[]> map);

    public void update(Map<String, String[]> map,String id);

    public void delete(String id);
}
