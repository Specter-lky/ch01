package com.pojo;

import java.util.List;

public class Orders {
    private int o_no;
    private int ct_no;
    private String g_name;
    private int o_num;
    private double g_price;
    private int o_status;
    private List<DList> dLists;
    public Orders(){

    }
    public Orders(int o_no, int ct_no,String g_name, int o_num, double g_price,int o_status) {
        this.o_no = o_no;
        this.ct_no = ct_no;
        this.g_name = g_name;
        this.o_num = o_num;
        this.g_price = g_price;
        this.o_status=o_status;
    }

    public int getO_no() {
        return o_no;
    }

    public void setO_no(int o_no) {
        this.o_no = o_no;
    }

    public int getCt_no() {
        return ct_no;
    }

    public void setCt_no(int ct_no) {
        this.ct_no = ct_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public int getO_num() {
        return o_num;
    }

    public void setO_num(int o_num) {
        this.o_num = o_num;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public int getO_status() {
        return o_status;
    }

    public void setO_status(int o_status) {
        this.o_status = o_status;
    }

    public List<DList> getdLists() {
        return dLists;
    }

    public void setdLists(List<DList> dLists) {
        this.dLists = dLists;
    }

    @Override
    public String toString(){
        return " "+o_no+" "+ct_no+" "+g_name+" "+o_num+" "+g_price+" "+o_status+" "+dLists;
    }
}
