package com.springboot.codingstudty.test;

/**
 * 描述：商品
 * @author ming
 * @version 1.0
 * @see
 */
public class Products {
    int id;
    String  name;
    String anchor;
    String des;
    String key;
    //Products和Images关系是1对n关系
    //可以存图片id,可以通过可变参数赋值
    int[] imgIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int[] getImgIds() {
        return imgIds;
    }

    public void setImgIds(int ...imgIds) {
        this.imgIds = imgIds;
    }
}
