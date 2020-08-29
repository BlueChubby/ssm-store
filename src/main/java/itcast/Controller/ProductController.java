package itcast.Controller;

import itcast.Pojo.Ms;
import itcast.Pojo.Product;
import itcast.Service.ProductService;
import itcast.Service.ProductServiceImpl;
import itcast.Service.UsersServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl proservice;

    @RequestMapping(path = "/profindall")
    public @ResponseBody List<Product> proFindAll() {
        List<Product> products = proservice.proFindAll();
        return products;
    }

    @RequestMapping(path = "/prostatusfindall")
    public  @ResponseBody  List<Product> proStatusFindAll() {
        List<Product> products = proservice.proStatusFindAll();
        return products;
    }

    @RequestMapping(path = "/probannerfindall")
    public  @ResponseBody  List<Product> proBannerFindAll() {
        List<Product> products = proservice.proBannerFindAll();
        return products;
    }

    @RequestMapping(path = "/promsfindall")
    public  @ResponseBody  List<Product> proMsFindAll() {
        List<Product> products = proservice.proMsFindAll();
        return products;
    }

    @RequestMapping(path = "/profindbyname")
    public  @ResponseBody  List<Product> proFindByName(String name) {
        List<Product> products = proservice.proFindByName("%"+name+"%");
        return products;
    }

    @RequestMapping(path = "/profindonebyid")
    public  @ResponseBody  Product proFindOneById(Integer pid) {
        Product product = proservice.proFindOneById(pid);
        return product;
    }

    @RequestMapping(path = "/profindbycid")
    public  @ResponseBody  List<Product> proFindByCategory_id(String cid) {
        List<Product> products =proservice.proFindByCategory_id(cid);
        return products;
    }


    @RequestMapping(path = "/proinsert")
    public  @ResponseBody  Integer proInsert(Product product) {
        Integer integer = proservice.proInsert(product);
        return integer;
    }


    @RequestMapping(path = "/prosxjia")
    public  @ResponseBody  Integer proSxjia(@Param("status") String status, @Param("pid") Integer pid) {
        System.out.println(status);
        System.out.println(pid);
        Integer integer = proservice.proSxjia(status, pid);
        return integer;
    }

    @RequestMapping(path = "/proms")
    public  @ResponseBody  Integer proMs(Integer is_ms, Integer msprice, Integer pid) {
        Integer integer = proservice.proMs(is_ms, msprice, pid);
        return integer;
    }

    @RequestMapping(path = "/prodelete")
    public  @ResponseBody  Integer proDelete(Integer pid) {
        Integer integer = proservice.proDelete(pid);
        return integer;
    }

}
