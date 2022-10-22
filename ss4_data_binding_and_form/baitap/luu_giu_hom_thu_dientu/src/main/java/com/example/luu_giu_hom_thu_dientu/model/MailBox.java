package com.example.luu_giu_hom_thu_dientu.model;

public class MailBox {
    private int id;
    private String language;
    private int size;
    private boolean spam;
    private String signature;

    public MailBox() {
    }

    public MailBox(int id, String language, int size, boolean spam, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
