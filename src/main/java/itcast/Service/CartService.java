package itcast.Service;

import itcast.Pojo.Cart;
import itcast.Pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CartService {

    //添加购物车
    public Integer cartInsert(Cart cart);

    //删除购物车
    public Integer deleteCart(Cart cart);

    //更新购物车商品数量
    Integer updateCart(Cart cart);

    //改变商品选中状态
    Integer updateChecked(Cart cart);

    //是否全选
    Integer updateCheckedAll(Cart cart);

    //查询购物车
    List<Cart> findCartAll(Integer uid);

    //查询该商品是否已经添加到购物车
    Cart findCartOne(Cart cart);

    //单个商品
    public Product proFindOneById(Integer pid);
}
