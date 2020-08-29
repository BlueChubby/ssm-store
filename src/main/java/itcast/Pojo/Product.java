package itcast.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;
    private Integer category_id;
    private String name;
    private String subtitle;
    private String main_image;
    private String sub_images;
    private String detail;
    private Integer price;
    private Integer is_ms;
    private Integer msprice;
    private Integer stock;

    public Integer getMsprice() {
        return msprice;
    }

    public void setMsprice(Integer msprice) {
        this.msprice = msprice;
    }

    private String status;
    private Integer is_new;
    private Integer is_hot;
    private Integer is_banner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Integer getIs_banner() {
        return is_banner;
    }

    public void setIs_banner(Integer is_banner) {
        this.is_banner = is_banner;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSub_images() {
        return sub_images;
    }

    public void setSub_images(String sub_images) {
        this.sub_images = sub_images;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIs_ms() {
        return is_ms;
    }

    public void setIs_ms(Integer is_ms) {
        this.is_ms = is_ms;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
