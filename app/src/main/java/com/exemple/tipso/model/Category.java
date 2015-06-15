package com.exemple.tipso.model;

/**
 * Created by adib on 23/04/15.
 */
public class Category {
    private int idCategory;
    private String categoryName;
    private String picture;
    private String description;

    public Category(){}
    public Category(int idCategory, String categoryName, String pictureCategory, String description) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.picture = pictureCategory;
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
