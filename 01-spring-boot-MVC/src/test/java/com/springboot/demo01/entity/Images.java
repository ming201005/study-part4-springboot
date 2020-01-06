package com.springboot.demo01.entity;

/**
 * 描述：商品图片
 *
 * @author ming
 * @version 1.0
 * @see
 */
public class Images {
    int id;
    String imgUrl;


    public Images(int id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
