package com.exemple.tipso.model;

/**
 * Created by adib on 23/04/15.
 */
public class CategoryChoosed {
    private int idCategoryChoosed;
    private int idCategory;
    private int idUser;

    public CategoryChoosed(){}

    public CategoryChoosed(int idCategoryChoosed, int idCategory, int idUser) {
        this.idCategoryChoosed = idCategoryChoosed;
        this.idCategory = idCategory;
        this.idUser = idUser;
    }

    public int getIdCategoryChoosed() {
        return idCategoryChoosed;
    }

    public void setIdCategoryChoosed(int idCategoryChoosed) {
        this.idCategoryChoosed = idCategoryChoosed;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
