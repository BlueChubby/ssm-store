package itcast.Service;

import itcast.Dao.ProductDao;
import itcast.Dao.UserDao;
import itcast.Pojo.Ms;
import itcast.Pojo.Product;
import itcast.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("proservice")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> proFindAll() {
        List<Product> products = productDao.proFindAll();
        return products;
    }

    @Override
    public List<Product> proStatusFindAll() {
        List<Product> products = productDao.proStatusFindAll();
        return products;
    }

    @Override
    public List<Product> proBannerFindAll() {
        List<Product> products = productDao.proBannerFindAll();
        return products;
    }

    @Override
    public List<Product> proMsFindAll() {
        List<Product> products = productDao.proMsFindAll();
        return products;
    }

    @Override
    public List<Product> proFindByName(String name) {
        List<Product> products = productDao.proFindByName(name);
        return products;
    }

    @Override
    public Product proFindOneById(Integer pid) {
        Product product = productDao.proFindOneById(pid);
        return product;
    }

    @Override
    public List<Product> proFindByCategory_id(String cid) {
        List<Product> products = productDao.proFindByCategory_id(cid);
        return products;
    }

    @Override
    public Integer proInsert(Product product) {
        Integer integer = productDao.proInsert(product);
        return integer;
    }

    @Override
    public Integer proSxjia(String status, Integer pid) {
        System.out.println("------------------");
        System.out.println(status);
        System.out.println(pid);
        Integer integer = productDao.proSxjia(status, pid);
        return integer;
    }

    @Override
    public Integer proMs(Integer is_ms, Integer msprice, Integer pid) {
        Integer integer = productDao.proMs(is_ms, msprice, pid);
        return integer;
    }

    @Override
    public Integer proDelete(Integer pid) {
        Integer integer = productDao.proDelete(pid);
        return integer;
    }

}
