package com.example.groceryapp.models;

public class RecommendedProducts {
    String name;
    String rating;
    String discount;
    String type;
    String img_url;

    public RecommendedProducts(){

    }
    public RecommendedProducts(String name,
                           String rating,
                           String discount,
                           String type,
                           String img_url){

        this.name=name;
        this.rating=rating;
        this.discount=discount;
        this.type=type;
        this.img_url=img_url;

    }
    public String getName(){
        return name;

    }

    public String getRating(){
        return rating;

    }
    public String getDiscount(){
        return discount;
    }
    public String getType(){
        return type;
    }
    public String getImg_url(){
        return img_url;
    }
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


}
