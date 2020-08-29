package itcast.Service;

import itcast.Pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersService {

    //查询所有用户
    public List<User> userFindAll();

    //查询单个用户
    public User userFindOneByName(String name);
    public User userFindOneByPhone(String phone);

    //查询单个用户byid
    public User userFindOneById(Integer id);

    //添加用户（注册）
    public Integer userInsert(User user);

    //用户登录
    public Integer userLogin();

    //删除用户(注销)
    public Integer userDelete();
}
