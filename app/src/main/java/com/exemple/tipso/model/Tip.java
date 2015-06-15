package com.exemple.tipso.model;

import java.util.Date;

/**
 * Created by adib on 23/04/15.
 */
public class Tip {
    private int idTip;
    private String picture;
    private String title;
    private String description;
    private String youtubeLink;
    private int numberView;
    private int numberComment;
    private Date datePublication;

    public Tip(){}
    public Tip(int idTip, String picture, String title, String description, String youtubeLink, int numberView, int numberComment, Date datePublication) {
        this.idTip = idTip;
        this.picture = picture;
        this.title = title;
        this.description = description;
        this.youtubeLink = youtubeLink;
        this.numberView = numberView;
        this.numberComment = numberComment;
        this.datePublication = datePublication;
    }

    public int getIdTip() {
        return idTip;
    }

    public void setIdTip(int idTip) {
        this.idTip = idTip;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public int getNumberView() {
        return numberView;
    }

    public void setNumberView(int numberView) {
        this.numberView = numberView;
    }

    public int getNumberComment() {
        return numberComment;
    }

    public void setNumberComment(int numberComment) {
        this.numberComment = numberComment;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }
}
