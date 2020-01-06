package com.springboot.demo01.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * 描述：测试
 *
 * @author ming
 * @version 1.0
 * @see
 */
public class MainTest {

    /**
     * main函数
     */
    public static void main(String[] args) {
        System.out.println ("--main---");
        MainTest mainTest = new MainTest();

        String json = mainTest.getJsonData ().toJSONString ();
        //输出测试
        System.out.println (json);
    }

    /**
     * 返回给UI的数据（一般在Controller层）
     * @return
     */
    public  JSONObject getJsonData() {
        JSONObject jsonObject =  new  JSONObject();
        //假设是从数据库取得数据
        Products[] products =  this.productsData();
        JSONArray jsonProductData = new JSONArray ();
        for (Products item:products) {
            //转换方式1：
            JSONObject itemObject =  new  JSONObject();
            itemObject.put ("id", item.getId ());
            itemObject.put ("name", item.getName ());
            itemObject.put ("anchor", item.getAnchor ());
            itemObject.put ("key", item.getKey ());
            JSONArray jsonArray = new JSONArray ();
            //转换方式2：在MVC框架中提倡定义VO给视图层。
            //可以让PO转VO，这样显得更加面向对象。不过简单的示例是没必要那样做。
            //处理一下图，只要URL
            int[] imgIds = item.getImgIds ();
            Arrays.stream (this.imgData()).forEach (val->{
                 Arrays.stream (imgIds).forEach (f->{
                     if(f==val.getId ()) jsonArray.add (val.imgUrl);
                 });
            });

            itemObject.put ("list", jsonArray);

            jsonProductData.add (itemObject);
        }
        //一般前端要的JSON格式
        jsonObject.put ("code", 200);
        jsonObject.put ("data", jsonProductData);
        jsonObject.put ("message", "SUCCESS");
        return jsonObject;
    }

    //===================假设下面是从数据库取出来的数据
    //模拟商品
    public Products[] productsData() {
        //假设有3条记录
        Products[] products = new Products[3];

        //第1件衣服
        Products item = new Products ();
        item.setId (1);
        item.setName ("女款风衣");
        item.setAnchor ("model_img111");
        item.setKey ("女装");
        item.setDes ("女装衣服，冬季");
        //通过可变参数，假设有3张图片
        item.setImgIds (1,2,5);
        products[0] = item;

        //第2件衣服
        item = new Products ();
        item.setId (2);
        item.setName ("男款羽绒服");
        item.setAnchor ("model_img");
        item.setKey ("男款");
        item.setDes ("男款长款羽绒服，冬季保暖哦。");
        //通过可变参数，假设有2张图片
        item.setImgIds (3,4);
        products[1] = item;

        //第3件衣服
        item = new Products ();
        item.setId (3);
        item.setName ("儿童套装");
        item.setAnchor ("model_img");
        item.setKey ("儿童款");
        item.setDes ("冬季保暖儿童衣服。");
        //通过可变参数，假设有N张图片
        item.setImgIds (3,4,6,7,8);
        products[2] = item;

        return products;
    }

    //图片数据：假设是数据库里的数据
    public Images[] imgData(){
        //假设有8条记录
        Images[] images = new Images[8];
        images[0] = new Images (1, "//url:AAA/FR1TY.jpg");
        images[1] = new Images (2, "//url:BBB/1x5xF.jpg");
        images[2] = new Images (3, "//url:CCC/sdFGe1.jpg");
        images[3] = new Images (4, "//url:DDD/334DFD1.jpg");
        images[4] = new Images (5, "//url:EEE/FDG1.jpg");
        images[5] = new Images (6, "//url:FFF/1TEFFV.jpg");
        images[6] = new Images (7, "//url:GGG/GH1DF.jpg");
        images[7] = new Images (8, "//url:HHH/FH1RT.jpg");
        return images;
    }
}
