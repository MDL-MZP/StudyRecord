package service;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public void insert(Map<String, String[]> map);

    public void update(Map<String, String[]> map,String id);

    public void delete(String id);
}
