package itcast.Test;

import itcast.Service.UsersServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test(){
//        UsersServiceImpl usersService=new UsersServiceImpl();
//        usersService.userFindAll();
        //加载配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        //获取对象
        UsersServiceImpl us= (UsersServiceImpl) ac.getBean("userservice");
        //调用方法
        us.userFindAll();
    }
//    @Test
//    public void mybatis() throws Exception {
//        //加载配置文件
//        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
//        //创建sqlsessionfactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsReader);
//        //创建sqlsession对象
//        SqlSession sqlSession=factory.openSession();
//        //获取代理对象
//        UserDao dao=sqlSession.getMapper(UserDao.class);
//        //查询所有数据
//        List<User> users = dao.userFindAll();
//        for (User user : users){
//            System.out.println(user.toString());
//        }
//        sqlSession.close();
//        resourceAsReader.close();
//
//    }
//
//    @Test
//    public void insert() throws Exception {
//        //加载配置文件
//        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
//        //创建sqlsessionfactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsReader);
//        //创建sqlsession对象
//        SqlSession sqlSession=factory.openSession();
//        //获取代理对象
//        UserDao dao=sqlSession.getMapper(UserDao.class);
//        User user=new User();
//        user.setAge(23);
//        user.setName("小米");
//        user.setPassword("ppppppppp");
//        user.setPhonenum("111111111111");
//        user.setSex("nan");
//        //添加数据
//        Integer num = dao.userInsert(user);
//        sqlSession.commit();
//        sqlSession.close();
//        resourceAsReader.close();
//
//    }


}
