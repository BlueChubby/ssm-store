package itcast.Service;

import itcast.Pojo.Ms;
import itcast.Pojo.Product;
import itcast.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface ProductService {
    //查询所有商品
    public List<Product> proFindAll();

    //查询所有上架商品（前台用）
    public List<Product> proStatusFindAll();

    //查询banner商品
    public List<Product> proBannerFindAll();

    //查询秒杀商品
    public List<Product> proMsFindAll();

    //模糊搜索
    public List<Product> proFindByName(String name);

    //详情页面
    public Product proFindOneById(Integer pid);

    //分类查询
    public List<Product> proFindByCategory_id(String cid);

    //添加商品
    public Integer proInsert(Product product);

    //上架/下架
    public Integer proSxjia(String status,Integer pid);

    //是否秒杀
    public Integer proMs(Integer isms,Integer msprice,Integer pid);

    //删除商品
    public Integer proDelete(Integer pid);

}
