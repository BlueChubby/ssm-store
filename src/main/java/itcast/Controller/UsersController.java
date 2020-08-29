package itcast.Controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import itcast.Pojo.Result;
import itcast.Pojo.SendResult;
import itcast.Pojo.User;
import itcast.Service.UsersServiceImpl;
import itcast.Utils.RandomToken;
import itcast.Utils.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @RequestMapping(path = "/userfindall")
    public @ResponseBody List<User> userFindAll(){
        List<User> userList=usersService.userFindAll();
        System.out.println("controller查询所有用户");
        return userList;
    }

    @RequestMapping(path = "/userregister")
    public @ResponseBody Integer userRegister(User user){

        return usersService.userInsert(user);
    }

    //用户名登录
    @RequestMapping(path = "/namelogin")
    public @ResponseBody Result nameLogin(String name,String password,HttpSession session){
        User user=usersService.userFindOneByName(name);
        Result result=new Result();
        if (user==null){
            result.setStatus(0);
            return result;
        }else {
            if (user.getPassword().equals(password)){
                session.setAttribute("UID",user.getId());
                result.setStatus(2);
                result.setToken(RandomToken.getRandomString(10));
                result.setUsername(user.getName());
                return result;
            }else {
                result.setStatus(1);
                return result;
            }
        }
    }
    //手机号登录
    @RequestMapping(path = "/phonelogin")
    public @ResponseBody Result phoneLogin(String phone,String password,HttpSession session){
        User user=usersService.userFindOneByPhone(phone);
        Result result=new Result();
        if (user==null){
            result.setStatus(0);
            return result;
        }else {
            if (user.getPassword().equals(password)){
                session.setAttribute("UID",user.getId());
                result.setStatus(2);
                result.setToken(RandomToken.getRandomString(10));
                result.setUsername(user.getName());
                return result;
            }else {
                result.setStatus(1);
                return result;
            }
        }
    }

    //查询byid
    @RequestMapping(path = "/userfindonebyid")
    public @ResponseBody User phoneLogin(HttpSession session){
        User user = usersService.userFindOneById(Integer.parseInt(String.valueOf(session.getAttribute("UID"))));
        return user;
    }

    //验证码登录
    @RequestMapping(path = "/codelogin")
    public @ResponseBody Result codeLogin(String phone, String code,HttpSession session){
        User user=usersService.userFindOneByPhone(phone);
        Result result=new Result();
        if (user==null){
            result.setStatus(0);
            return result;
        }else {
            if (code.equals(String.valueOf(session.getAttribute("code")))){
                session.setAttribute("UID",user.getId());
                result.setStatus(2);
                result.setToken(RandomToken.getRandomString(10));
                result.setUsername(user.getName());
                return result;
            }else {
                result.setStatus(1);
                return result;
            }
        }
    }

    //验证码注册
    @RequestMapping(path = "/coderegister")
    public @ResponseBody Integer codeRegister(User user,HttpSession session){
        if ("888666".equals(user.getCode())){
            return usersService.userInsert(user);
        }else {
            return 0;
        }
    }

    //发送验证码
    @RequestMapping(path = "/getcode")
    public @ResponseBody Integer getCode(String phone, HttpSession session){
        User user=usersService.userFindOneByPhone(phone);
        if (user==null){
            return 0;
        }else {
            SendResult sendResult = SendSms.sendCode(phone);
            if (sendResult.getStatus()==200){
                session.setAttribute("code",888666);
                return 200;
            }else {
                return 404;
            }
        }
    }

    //注册发送验证码
    @RequestMapping(path = "/registergetcode")
    public @ResponseBody Integer registergetCode(String phone, HttpSession session){
        User user=usersService.userFindOneByPhone(phone);
        if (user!=null){
            return 0;
        }else {
            SendResult sendResult = SendSms.sendCode(phone);
            if (sendResult.getStatus()==200){
                session.setAttribute("recode",888666);
                return 200;
            }else {
                return 404;
            }
        }
    }
}
