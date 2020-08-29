package itcast.Service;

import itcast.Dao.UserDao;
import itcast.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userservice")
public class UsersServiceImpl implements UsersService{
//
    @Autowired
    private UserDao userDao;
    public List<User> userFindAll() {
        List<User> users = userDao.userFindAll();
        System.out.println("service层查询所有用户");
        return users;
    }

    @Override
    public User userFindOneByName(String name) {
        User user = userDao.userFindOneByName(name);
        return user;
    }

    @Override
    public User userFindOneByPhone(String phone) {
        User user=userDao.userFindOneByPhone(phone);
        return user;
    }

    @Override
    public User userFindOneById(Integer id) {
        User user = userDao.userFindOneById(id);
        return user;
    }

    //用户注册
    @Override
    public Integer userInsert(User user) {
        Integer integer = userDao.userInsert(user);
        System.out.println(integer);
        return integer;
    }

    @Override
    public Integer userLogin() {
        return null;
    }

    @Override
    public Integer userDelete() {
        return null;
    }
}
