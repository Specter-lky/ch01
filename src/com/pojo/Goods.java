package com.pojo;

public class Goods {
    private int g_no;
    private String g_name;
    private int g_num;
    private double g_price;
    private double g_bprice;

    public Goods(int g_no, String g_name, int g_num,double g_price,double g_bprice) {
        this.g_no = g_no;
        this.g_name = g_name;
        this.g_num = g_num;
        this.g_price=g_price;
        this.g_bprice=g_bprice;
    }

    public int getG_no() {
        return g_no;
    }

    public void setG_no(int g_no) {
        this.g_no = g_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public double getG_bprice() {
        return g_bprice;
    }

    public void setG_bprice(double g_bprice) {
        this.g_bprice = g_bprice;
    }
}
