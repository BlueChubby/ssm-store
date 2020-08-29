package itcast.Dao;

import itcast.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //查询所有用户
    @Select("select * from user")
    public List<User> userFindAll();

    //查询单个用户
    @Select("select * from user where name=#{name}")
    public User userFindOneByName(String name);

    //查询单个用户byid
    @Select("select * from user where id=#{id}")
    public User userFindOneById(Integer id);

    @Select("select * from user where phonenum=#{phone}")
    public User userFindOneByPhone(String phone);
    //添加用户（注册）
    @Insert("insert into user values(null,#{name},null,#{password},now(),null,null,#{phonenum},null,0,0,1,0)")
    public Integer userInsert(User user);

    //用户登录
    public Integer userLogin();

    //删除用户(注销)
    public Integer userDelete();
}
