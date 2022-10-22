package com.example.luu_giu_hom_thu_dientu.model;

import java.util.Date;

public class DeclarationMedical {
    private int id;
    private String ten;
    private int namSinh;
    private String gender;
    private String quocTich;
    private String cmnd;
    private String thongTinDiLai;
    private String soHieuPhuongTien;
    private int soGhe;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String thongTinGanDay;

    private String tinh;
    private String huyen;
    private String xa;

    private String diaChi;
    private String sdt;
    private String email;

    private boolean sot;
    private boolean ho;
    private boolean khoTho;
    private boolean dauHong;
    private boolean non;
    private boolean tieuChay;
    private boolean xuatHuyet;
    private boolean noiBan;

    private boolean tiepXucDongVat;
    private boolean tiepXucNguoiBenh;


    public DeclarationMedical() {
    }

    public DeclarationMedical(int id, String ten, int namSinh, String gender, String quocTich, String cmnd,
                              String thongTinDiLai, String soHieuPhuongTien, int soGhe, Date ngayBatDau, Date ngayKetThuc,
                              String thongTinGanDay, String tinh, String huyen, String xa, String diaChi, String sdt,
                              String email, boolean sot, boolean ho, boolean khoTho, boolean dauHong, boolean non,
                              boolean tieuChay, boolean xuatHuyet, boolean noiBan, boolean tiepXucDongVat,
                              boolean tiepXucNguoiBenh) {
        this.id = id;
        this.ten = ten;
        this.namSinh = namSinh;
        this.gender = gender;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.thongTinDiLai = thongTinDiLai;
        this.soHieuPhuongTien = soHieuPhuongTien;
        this.soGhe = soGhe;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.thongTinGanDay = thongTinGanDay;
        this.tinh = tinh;
        this.huyen = huyen;
        this.xa = xa;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.non = non;
        this.tieuChay = tieuChay;
        this.xuatHuyet = xuatHuyet;
        this.noiBan = noiBan;
        this.tiepXucDongVat = tiepXucDongVat;
        this.tiepXucNguoiBenh = tiepXucNguoiBenh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(String thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getThongTinGanDay() {
        return thongTinGanDay;
    }

    public void setThongTinGanDay(String thongTinGanDay) {
        this.thongTinGanDay = thongTinGanDay;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSot() {
        return sot;
    }

    public void setSot(boolean sot) {
        this.sot = sot;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKhoTho() {
        return khoTho;
    }

    public void setKhoTho(boolean khoTho) {
        this.khoTho = khoTho;
    }

    public boolean isDauHong() {
        return dauHong;
    }

    public void setDauHong(boolean dauHong) {
        this.dauHong = dauHong;
    }

    public boolean isNon() {
        return non;
    }

    public void setNon(boolean non) {
        this.non = non;
    }

    public boolean isTieuChay() {
        return tieuChay;
    }

    public void setTieuChay(boolean tieuChay) {
        this.tieuChay = tieuChay;
    }

    public boolean isXuatHuyet() {
        return xuatHuyet;
    }

    public void setXuatHuyet(boolean xuatHuyet) {
        this.xuatHuyet = xuatHuyet;
    }

    public boolean isNoiBan() {
        return noiBan;
    }

    public void setNoiBan(boolean noiBan) {
        this.noiBan = noiBan;
    }

    public boolean isTiepXucDongVat() {
        return tiepXucDongVat;
    }

    public void setTiepXucDongVat(boolean tiepXucDongVat) {
        this.tiepXucDongVat = tiepXucDongVat;
    }

    public boolean isTiepXucNguoiBenh() {
        return tiepXucNguoiBenh;
    }

    public void setTiepXucNguoiBenh(boolean tiepXucNguoiBenh) {
        this.tiepXucNguoiBenh = tiepXucNguoiBenh;
    }

    @Override
    public String toString() {
        return "DeclarationMedical{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", namSinh=" + namSinh +
                ", gender='" + gender + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", thongTinDiLai='" + thongTinDiLai + '\'' +
                ", soHieuPhuongTien='" + soHieuPhuongTien + '\'' +
                ", soGhe=" + soGhe +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", thongTinGanDay='" + thongTinGanDay + '\'' +
                ", tinh='" + tinh + '\'' +
                ", huyen='" + huyen + '\'' +
                ", xa='" + xa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", sot=" + sot +
                ", ho=" + ho +
                ", khoTho=" + khoTho +
                ", dauHong=" + dauHong +
                ", non=" + non +
                ", tieuChay=" + tieuChay +
                ", xuatHuyet=" + xuatHuyet +
                ", noiBan=" + noiBan +
                ", tiepXucDongVat=" + tiepXucDongVat +
                ", tiepXucNguoiBenh=" + tiepXucNguoiBenh +
                '}';
    }

}
