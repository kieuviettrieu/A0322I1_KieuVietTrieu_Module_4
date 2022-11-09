package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private int point;
    private String author;
    private String feedBack;
    private int likeComment;

    public Comment() {
    }

    public Comment(int point, String author, String feedBack, int like) {
        this.point = point;
        this.author = author;
        this.feedBack = feedBack;
        this.likeComment = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getLikeComment() {
        return likeComment;
    }

    public void setLikeComment(int likeComment) {
        this.likeComment = likeComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", point=" + point +
                ", author='" + author + '\'' +
                ", feedBack='" + feedBack + '\'' +
                ", like=" + likeComment +
                '}';
    }
}