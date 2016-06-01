/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 * ItemとCart、BuyConfirmで使用したいJavaBeans Itemでは使用しないが、個数を格納できる。
 * cartにDBを作成したのは、ブラウザを閉じても維持したかったから
 */
public class LookCartBeans implements Serializable {

    private String Url;
    private String name;
    private String code;
    private int price;
    private String image;//146×146サイズ
    private String description;//説明
    private int number;

    public LookCartBeans() {
        this.Url = "";
        this.name = "";
        this.price = 0;
        this.image = "";
        this.code = "";
        this.description = "";
        this.number = 0;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
