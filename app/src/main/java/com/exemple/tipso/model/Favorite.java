package com.exemple.tipso.model;

import java.util.Date;

/**
 * Created by adib on 23/04/15.
 */
public class Favorite {
    private int idFavorite;
    private Date date;

    private int idUser;
    private int idTip;

    public Favorite(){}
    public Favorite(int idFavorite, Date date, int idUser, int idTip) {
        this.idFavorite = idFavorite;
        this.date = date;
        this.idUser = idUser;
        this.idTip = idTip;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTip() {
        return idTip;
    }

    public void setIdTip(int idTip) {
        this.idTip = idTip;
    }

    public int getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(int idFavorite) {
        this.idFavorite = idFavorite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
