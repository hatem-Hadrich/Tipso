package com.exemple.tipso.model;

/**
 * Created by adib on 23/04/15.
 */
public class Comment {
    private int idComment;
    private String description;

    private int idUser;
    private int idTip;

    public Comment(){}
    public Comment(int idComment, String description, int idUser, int idTip) {
        this.idComment = idComment;
        this.description = description;
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

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
