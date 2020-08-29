package itcast.Service;

import itcast.Dao.CartDao;
import itcast.Pojo.Cart;
import itcast.Pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartservice")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Override
    public Integer cartInsert(Cart cart) {
        Integer integer = cartDao.cartInsert(cart);
        return integer;
    }

    @Override
    public Integer deleteCart(Cart cart) {
        Integer integer = cartDao.deleteCart(cart);
        return integer;
    }

    @Override
    public Integer updateCart(Cart cart) {
        Integer integer = cartDao.updateCart(cart);
        return integer;
    }

    @Override
    public Integer updateChecked(Cart cart) {
        Integer integer = cartDao.updateChecked(cart);
        return integer;
    }

    @Override
    public Integer updateCheckedAll(Cart cart) {
        Integer integer = cartDao.updateCheckedAll(cart);
        return integer;
    }

    @Override
    public List<Cart> findCartAll(Integer uid) {
        List<Cart> cartAll =cartDao.findCartAll(uid);
        return cartAll;
    }

    @Override
    public Cart findCartOne(Cart cart) {
        Cart cartOne = cartDao.findCartOne(cart);
        return cartOne;
    }

    @Override
    public Product proFindOneById(Integer pid) {
        Product product = cartDao.proFindOneById(pid);
        return product;
    }
}
