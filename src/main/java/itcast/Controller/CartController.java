package itcast.Controller;

import itcast.Pojo.Cart;
import itcast.Pojo.Product;
import itcast.Pojo.User;
import itcast.Service.CartServiceImpl;
import itcast.Service.ProductServiceImpl;
import itcast.Utils.OV.CartAndProductVO;
import itcast.Utils.OV.VOutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;
    private Integer UID;
    @RequestMapping(path = "/insertcart")
    public @ResponseBody  Integer cartInsert(Cart cart) {
        cart.setUser_id(UID);
        Integer integer = cartService.cartInsert(cart);
        return integer;
    }
    @RequestMapping(path = "/deletepro")
    public @ResponseBody  Integer deleteCart(Cart cart) {
        cart.setUser_id(UID);
        Integer integer = cartService.deleteCart(cart);
        return integer;
    }

    @RequestMapping(path = "/upquan")
    public @ResponseBody  Integer updateCart(Cart cart) {
        cart.setUser_id(UID);
        Integer integer = cartService.updateCart(cart);
        return integer;
    }

    @RequestMapping(path = "/upcheck")
    public @ResponseBody  Integer updateChecked(Cart cart) {
        cart.setUser_id(UID);
        Integer integer = cartService.updateChecked(cart);
        return integer;
    }

    @RequestMapping(path = "/upcheckall")
    public @ResponseBody  Integer updateCheckedAll(Cart cart) {
        cart.setUser_id(UID);
        Integer integer = cartService.updateCheckedAll(cart);
        return integer;
    }

    @RequestMapping(path = "/cartfindone")
    public @ResponseBody Integer cartFindOne(Cart cart) {
        cart.setUser_id(UID);
        System.out.println(cart.toString());
        Cart cartOne = cartService.findCartOne(cart);
        if (cartOne==null){
            return 0;
        }else {
            return 1;
        }
    }

    @RequestMapping(path = "/findcartall")
    public @ResponseBody List<CartAndProductVO> findCartAll() {
        List<CartAndProductVO> cartAndProductVOS=new ArrayList<>();
//        List<Cart> cartAll =cartService.findCartAll(Integer.parseInt(String.valueOf(session.getAttribute("UID"))));
        List<Cart> cartAll =cartService.findCartAll(UID);
        for (Cart cart:cartAll){
            Product product = cartService.proFindOneById(cart.getProduct_id());
            CartAndProductVO cpVo = VOutils.getCpVo(product, cart);
            cartAndProductVOS.add(cpVo);
        }
        return cartAndProductVOS;
    }

    @ModelAttribute
    public void getUID(HttpSession session){
        Object uid = session.getAttribute("UID");
        UID= Integer.parseInt(String.valueOf(uid));
//        UID=31;
    }
}
