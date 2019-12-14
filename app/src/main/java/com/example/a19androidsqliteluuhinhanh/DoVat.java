package com.example.a19androidsqliteluuhinhanh;

public class DoVat
{
    private int Id;
    private String ten;
    private String moTa;
    private byte[] hinh;

    public DoVat() {
    }

    public DoVat(int id, String ten, String moTa, byte[] hinh) {
        Id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

}
