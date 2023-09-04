package com.example.like_dislike;

public class Message {
    private String text;
    private Integer likes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Message(String text, Integer likes, Integer dislikes) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    private Integer dislikes;
}
