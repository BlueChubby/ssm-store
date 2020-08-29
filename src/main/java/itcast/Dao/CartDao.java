package itcast.Dao;

import itcast.Pojo.Cart;
import itcast.Pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {

    //添加购物车
    @Insert("insert into neuedu_cart values(null,#{user_id},#{product_id},#{quantity},1,now(),null)")
    public Integer cartInsert(Cart cart);

    //删除购物车
    @Delete("delete from neuedu_cart where product_id=#{product_id} and user_id=#{user_id}")
    public Integer deleteCart(Cart cart);

    //更新购物车商品数量
    @Update("update neuedu_cart set quantity=#{quantity},update_time=now() where product_id=#{product_id} and user_id=#{user_id}")
    Integer updateCart(Cart cart);

    //改变商品选中状态
    @Update("update neuedu_cart set checked=#{checked} where product_id=#{product_id} and user_id=#{user_id}")
    Integer updateChecked(Cart cart);

    //是否全选
    @Update("update neuedu_cart set checked=#{checked} where user_id=#{user_id}")
    Integer updateCheckedAll(Cart cart);

    //查询购物车
    @Select("select * from neuedu_cart where user_id=#{uid}")
    List<Cart> findCartAll(Integer uid);

    //查询该商品是否已经添加到购物车
    @Select("select * from neuedu_cart where user_id=#{user_id} and product_id=#{product_id}")
    Cart findCartOne(Cart cart);

    //单个商品
    @Select("select * from neuedu_product where id=#{pid}")
    Product proFindOneById(Integer pid);
}
