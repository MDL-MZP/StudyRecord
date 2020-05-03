package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 调用dao完成查询
        return dao.findAll();
    }

    @Override
    public void insert(Map<String, String[]> map){
        dao.insert(map);
    }

    @Override
    public void update(Map<String, String[]> map,String id){
        dao.update(map,id);
    }

    @Override
    public void delete(String id){
        dao.delete(id);
    }
}
