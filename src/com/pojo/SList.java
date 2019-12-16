package com.pojo;

public class SList {
    private int sl_no;
    private String g_name;
    private int sl_num;
    private double sl_price;

    public SList(int sl_no, String g_name, int sl_num, double sl_price) {
        this.sl_no = sl_no;
        this.g_name = g_name;
        this.sl_num = sl_num;
        this.sl_price = sl_price;
    }

    public int getSl_no() {
        return sl_no;
    }

    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public int getSl_num() {
        return sl_num;
    }

    public void setSl_num(int sl_num) {
        this.sl_num = sl_num;
    }

    public double getSl_price() {
        return sl_price;
    }

    public void setSl_price(double sl_price) {
        this.sl_price = sl_price;
    }
}
