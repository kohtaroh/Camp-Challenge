/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 *Searchで一覧に表示するときに使用するJavaBeans
 * この段階でAPIから取得する情報量を少しでも抑えたい
 */
public class SearchResultBeans implements Serializable {

    private String name;
    private String code;
    private String price;
    private String image;//146×146サイズ

    public SearchResultBeans() {

        this.name = "";
        this.price = "";
        this.image = "";
        this.code = "";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public void SRBtoLCBMapping(LookCartBeans lcb) {
        lcb.setName(this.name);
        lcb.setPrice(Integer.parseInt(this.price));
        lcb.setImage(this.image);
        lcb.setCode(this.code);

    }

}
