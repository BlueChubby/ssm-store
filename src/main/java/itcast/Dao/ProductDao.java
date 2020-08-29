package itcast.Dao;

import itcast.Pojo.Ms;
import itcast.Pojo.Product;
import itcast.Pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductDao {
    //查询所有商品
    @Select("select * from neuedu_product")
    public List<Product> proFindAll();

    //查询所有上架商品（前台用）
    @Select("select * from neuedu_product where status=1 and is_ms=0")
    public List<Product> proStatusFindAll();

    //查询banner商品
    @Select("select * from neuedu_product where is_banner=1 and status=1")
    public List<Product> proBannerFindAll();


    //查询秒杀商品
    @Select("select * from neuedu_product where is_banner=0 and status=1 and is_ms=1")
    public List<Product> proMsFindAll();

    //模糊搜索
    @Select("select * from neuedu_product where name like #{name}")
    public List<Product> proFindByName(String name);

    //详情页面
    @Select("select * from neuedu_product where id=#{pid}")
    public Product proFindOneById(Integer pid);

    //分类查询
    @Select("select * from neuedu_product where category_id=#{cid}")
    public List<Product> proFindByCategory_id(String cid);

    //添加商品
    @Insert("insert into neuedu_product values(null,#{category_id},#{name},#{subtitle},#{main_image},#{sub_images},#{detail},#{price},#{stock},#{status},1,1,0,now(),null,#{smallbanner},#{is_ms}),null")
    public Integer proInsert(Product product);

    //上架/下架
    @Update("update neuedu_product set status=#{status} where id=#{pid}")
    public Integer proSxjia(@Param("status") String status, @Param("pid") Integer pid);

    //设置商品是否秒杀
    @Update("update neuedu_product set is_ms=#{is_ms}, msprice=#{msprice} where id=#{pid}")
    public Integer proMs(@Param("is_ms")Integer is_ms,@Param("msprice")Integer msprice,@Param("pid")Integer pid);

    //删除商品
    @Delete("delete from neuedu_product where id=#{pid}")
    public Integer proDelete(Integer pid);

}
