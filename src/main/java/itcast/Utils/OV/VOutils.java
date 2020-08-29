package itcast.Utils.OV;

import itcast.Pojo.Cart;
import itcast.Pojo.Order;
import itcast.Pojo.Product;
import itcast.Pojo.Shipping;

import java.math.BigDecimal;

public class VOutils {

    public static CartAndProductVO getCpVo(Product p, Cart c){
        CartAndProductVO cad = new CartAndProductVO();
        cad.setId(p.getId());
        cad.setMain_image(p.getMain_image());
        cad.setSubtitle(p.getSubtitle());
        cad.setPrice(p.getPrice());
        if (c.getQuantity()>p.getStock()){
            cad.setQuantity(p.getStock());
        }else {
            cad.setQuantity(c.getQuantity());
        }
        cad.setChecked(String.valueOf(c.getChecked()));
        cad.setDetail(p.getDetail());
        cad.setProduct_id(p.getId());
        cad.setName(p.getName());
//        BigDecimal tol=p.getPrice().multiply(new BigDecimal(c.getQuantity()));
        cad.setTotalPrice(p.getPrice()*c.getQuantity());

        return cad;
    }
    public static ShippingAndOrderVo getSaVo(Shipping s, Order o){

        ShippingAndOrderVo sao=new ShippingAndOrderVo();
        sao.setUser_id(o.getUser_id());
        sao.setDefaultadd(s.getDefaultadd());
        sao.setStatus(o.getStatus());
        sao.setOrder_no(o.getOrder_no());
        sao.setReceiver_phone(s.getReceiver_phone());
        sao.setReceiver_name(s.getReceiver_name());
        sao.setReceiver_mobile(s.getReceiver_mobile());
        sao.setPayment_time(o.getPayment_time());
        sao.setReceiver_province(s.getReceiver_province());
        sao.setReceiver_zip(s.getReceiver_zip());
        sao.setCreate_time(o.getCreate_time());
        sao.setReceiver_city(s.getReceiver_city());
        sao.setReceiver_address(s.getReceiver_address());
        sao.setShipping_id(s.getId());

        return sao;
    }
}
