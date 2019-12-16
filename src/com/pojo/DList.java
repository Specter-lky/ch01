package com.pojo;

public class DList {
    private int dl_no;
    private int o_no;
    private String g_name;
    private double g_price;
    private int dl_num;
    private int dl_status;
    private String dl_place;

    public DList(int dl_no, int o_no, String g_name,double g_price ,int dl_num, int dl_status, String dl_place) {
        this.dl_no = dl_no;
        this.o_no = o_no;
        this.g_name = g_name;
        this.g_price=g_price;
        this.dl_num = dl_num;
        this.dl_status = dl_status;
        this.dl_place = dl_place;
    }

    public int getDl_no() {
        return dl_no;
    }

    public void setDl_no(int dl_no) {
        this.dl_no = dl_no;
    }

    public int getO_no() {
        return o_no;
    }

    public void setO_no(int o_no) {
        this.o_no = o_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public int getDl_num() {
        return dl_num;
    }

    public void setDl_num(int dl_num) {
        this.dl_num = dl_num;
    }

    public int getDl_status() {
        return dl_status;
    }

    public void setDl_status(int dl_status) {
        this.dl_status = dl_status;
    }

    public String getDl_place() {
        return dl_place;
    }

    public void setDl_place(String dl_place) {
        this.dl_place = dl_place;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    @Override
    public String toString(){
        return ""+dl_no+" "+" "+o_no+" "+g_name+" "+g_price+" "+dl_num+" "+dl_place+" "+dl_status;
    }
}
