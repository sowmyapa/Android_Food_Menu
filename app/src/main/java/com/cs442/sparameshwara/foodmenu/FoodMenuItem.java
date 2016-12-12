package com.cs442.sparameshwara.foodmenu;

/**
 * Created by sowmyaparameshwara on 9/25/16.
 */
public class FoodMenuItem {

    public String foodName;
    public String price;
    public int resId;
    public int position;
    public String description;

    public FoodMenuItem(String foodName,String price,int resId,int position,String description){
        this.foodName = foodName;
        this.price = price;
        this.resId = resId;
        this.position = position;
        this.description = description;
    }

}
