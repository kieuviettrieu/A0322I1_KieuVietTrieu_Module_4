package com.example.tu_dien_don_gian.service;

import java.util.LinkedHashMap;

public class TuDien {
    private static LinkedHashMap<String,String> listTuDien=new LinkedHashMap<>();

    public TuDien() {
    }

    static {
        listTuDien.put("hello","xin chào");
        listTuDien.put("hi","xin chào");
        listTuDien.put("list","danh sách");
        listTuDien.put("language","ngôn ngữ");
        listTuDien.put("person","người");
        listTuDien.put("student","học sinh");
        listTuDien.put("teacher","giáo viên");
    }

    public static LinkedHashMap<String, String> getListTuDien() {
        return listTuDien;
    }

    public static void setListTuDien(LinkedHashMap<String, String> listTuDien) {
        TuDien.listTuDien = listTuDien;
    }

    public static String getDictionary(String key)
    {
        String keys=key.toLowerCase();
        return listTuDien.get(keys);
    }
}
