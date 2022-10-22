package com.example.luu_giu_hom_thu_dientu.service;

import com.example.luu_giu_hom_thu_dientu.model.MailBox;

public class MailBoxService implements IMailBoxService{
    public static MailBox mailBox;
    static {
        mailBox=new MailBox(1,"Japanese",10,true,"good");
    }

    @Override
    public void update(MailBox mailBox1) {
        mailBox.setLanguage(mailBox1.getLanguage());
        mailBox.setSize(mailBox1.getSize());
        mailBox.setSpam(mailBox1.isSpam());
        mailBox.setSignature(mailBox1.getSignature());
    }

    public MailBox getMailBox() {
        return mailBox;
    }
}
